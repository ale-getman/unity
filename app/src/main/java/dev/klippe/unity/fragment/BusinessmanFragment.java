package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import dev.klippe.unity.R;
import dev.klippe.unity.utils.MaskImage;

/**
 * Created by user on 20.08.2017.
 */

public class BusinessmanFragment extends Fragment {

    private static final int LAYOUT = R.layout.fragment_businessman;
    protected View view;
    private Context context;

    @BindView(R.id.business_img)
    public ImageView businessImg;

    @BindView(R.id.business_greetings)
    public TextView businessGreetings;

    @BindView(R.id.business_avatar)
    public CircleImageView businessAvatar;

    @BindView(R.id.business_name)
    public TextView businessName;

    @BindView(R.id.business_activities)
    public TextView businessActivities;

    @BindView(R.id.business_info1)
    public TextView businessInfo1;

    @BindView(R.id.business_info2)
    public TextView businessInfo2;

    @BindView(R.id.business_info3)
    public TextView businessInfo3;

    @BindView(R.id.business_inn)
    public TextView businessInn;

    @BindView(R.id.business_points)
    public TextView businessPoints;

    @BindView(R.id.business_events)
    public TextView businessEvents;

    @BindView(R.id.business_used_points)
    public TextView businessUsedPoints;

    @BindView(R.id.business_sell)
    public Button businessBtnSell;

    @BindView(R.id.business_buy)
    public Button businessBtnBuy;

    @BindView(R.id.business_settings)
    public TextView businessSettings;

    public static BusinessmanFragment getInstance(Context context) {
        Bundle args = new Bundle();
        BusinessmanFragment fragment = new BusinessmanFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        MaskImage mi = new MaskImage(context);
        businessImg.setImageBitmap(mi.getBitmap());
        businessImg.setScaleType(ImageView.ScaleType.FIT_XY);

        String buf = "ЗАО <font color='red'>\"MINIMARKET\"</font>";
        businessName.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Вид деятельности <font color='red'>Продукты питания/напитки</font>";
        businessActivities.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "<font color='red'>Сейчас для вашего бизнеса необходимо</font>";
        businessInfo3.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Доступно<br> для обмена<br> <h2><font color='red'>880</font></h2>";
        businessPoints.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Учтено событий<br> с участием<br> <h2><font color='green'>34</font></h2>";
        businessEvents.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Баллов<br> использовано<br> <h2><font color='grey'>400</font></h2>";
        businessUsedPoints.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);

        businessBtnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft;
                ft = getFragmentManager().beginTransaction();
                AddAdFragment addAdFragment = AddAdFragment.getInstance(context);
                ft.replace(R.id.main_frame, addAdFragment);
                ft.commit();
            }
        });

        businessBtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft;
                ft = getFragmentManager().beginTransaction();
                SearchFragment searchFragment = SearchFragment.getInstance(context);
                ft.replace(R.id.main_frame, searchFragment);
                ft.commit();
            }
        });

        return view;
    }
}
