package dev.klippe.unity.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import io.mahendra.calendarview.widget.CalendarView;

/**
 * Created by user on 13.07.2017.
 */

public class SwapScoreFragment extends Fragment {

    private static final int LAYOUT = R.layout.swapscore_fragment;
    protected View view;
    private Context context;


    @BindView(R.id.swapscore_history_btn)
    public ImageButton swapscore_history_btn;

    @BindView(R.id.swapscore_score_txt)
    public TextView swapscore_score_txt;

    @BindView(R.id.swapscore_grid)
    public GridView swapscore_grid;

    @BindView(R.id.swapscore_qr_btn)
    public Button swapscore_qr_btn;

    @BindView(R.id.swapscore_img)
    public ImageView swapscore_img;

    public static SwapScoreFragment getInstance(Context context) {
        Bundle args = new Bundle();
        SwapScoreFragment fragment = new SwapScoreFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);

        swapscore_img = ButterKnife.findById(view, R.id.swapscore_img);
        Bitmap original = BitmapFactory.decodeResource(getResources(),R.drawable.opacity);
        Bitmap mask = BitmapFactory.decodeResource(getResources(),R.drawable.mask);
        Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(result);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mCanvas.drawBitmap(original, 0, 0, null);
        mCanvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);
        swapscore_img.setImageBitmap(result);
        swapscore_img.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
