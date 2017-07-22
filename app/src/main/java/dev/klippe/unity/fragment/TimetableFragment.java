package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import dev.klippe.unity.utils.MaskImage;

/**
 * Created by user on 13.07.2017.
 */

public class TimetableFragment extends Fragment {

    private static final int LAYOUT = R.layout.timetable_fragment;
    protected View view;
    private Context context;

    @BindView(R.id.cal)
    public CalendarView calendarView;

    @BindView(R.id.timetable_img)
    public ImageView timetableImg;

    @BindView(R.id.timetable_list)
    public List timetable_list;

    public static TimetableFragment getInstance(Context context) {
        Bundle args = new Bundle();
        TimetableFragment fragment = new TimetableFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);

        timetableImg = ButterKnife.findById(view, R.id.timetable_img);
        MaskImage mi = new MaskImage(context);
        timetableImg.setImageBitmap(mi.getBitmap());
        timetableImg.setScaleType(ImageView.ScaleType.FIT_XY);

        calendarView = ButterKnife.findById(view, R.id.cal);

        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
