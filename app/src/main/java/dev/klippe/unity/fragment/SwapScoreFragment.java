package dev.klippe.unity.fragment;

import android.content.Context;
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

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
