package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import dev.klippe.unity.R;
import dev.klippe.unity.utils.MaskImage;

/**
 * Created by user on 05.08.2017.
 */

public class ProfileFragment extends Fragment {

    private static final int LAYOUT = R.layout.fragment_profile;
    protected View view;
    private Context context;

    @BindView(R.id.profile_progress_bar)
    public ProgressBar profileProgressBar;

    @BindView(R.id.profile_img)
    public ImageView profileImg;

    @BindView(R.id.profile_greetings)
    public TextView profileGreetings;

    @BindView(R.id.profile_avatar)
    public CircleImageView profileAvatar;

    @BindView(R.id.profile_exp)
    public TextView profileExp;

    @BindView(R.id.profile_info)
    public TextView profileInfo;

    @BindView(R.id.profile_id)
    public TextView profileId;

    @BindView(R.id.profile_points)
    public TextView profilePoints;

    @BindView(R.id.profile_events)
    public TextView profileEvents;

    @BindView(R.id.profile_used_points)
    public TextView profileUsedPoints;

    @BindView(R.id.profile_btn_swap_points)
    public Button profileBtnSwapPoints;

    @BindView(R.id.profile_settings)
    public TextView profileSettings;

    public static ProfileFragment getInstance(Context context) {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
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

        profileProgressBar.setProgress(47);

        MaskImage mi = new MaskImage(context);
        profileImg.setImageBitmap(mi.getBitmap());
        profileImg.setScaleType(ImageView.ScaleType.FIT_XY);

        String buf = "<font color='red'>1280/</font>1500";
        profileExp.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "До уровня <font color='red'>активный гражданин 3</font>";
        profileInfo.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Доступно<br> для обмена<br> <h2><font color='red'>880</font></h2>";
        profilePoints.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Учтено событий<br> с участием<br> <h2><font color='green'>34</font></h2>";
        profileEvents.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "Баллов<br> использовано<br> <h2><font color='grey'>400</font></h2>";
        profileUsedPoints.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);

        return view;
    }
}
