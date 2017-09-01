package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import dev.klippe.unity.adapter.EventAdapter;
import dev.klippe.unity.entity.EventEntity;
import dev.klippe.unity.utils.MaskImage;

/**
 * Created by user on 13.07.2017.
 */

public class TimetableFragment extends Fragment {

    private static final int LAYOUT = R.layout.timetable_fragment;
    protected View view;
    private Context context;

//    @BindView(R.id.cal)
//    public CalendarView calendarView;

    @BindView(R.id.timetable_img)
    public ImageView timetableImg;

    @BindView(R.id.timetable_list)
    public ListView timetable_list;

    @BindView(R.id.calendar)
    public CalendarView calendar;

    ArrayList<EventEntity> eventAdap = new ArrayList<EventEntity>();
    EventAdapter boxAdapter;


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
        ButterKnife.bind(this, view);

        MaskImage mi = new MaskImage(context);
        timetableImg.setImageBitmap(mi.getBitmap());
        timetableImg.setScaleType(ImageView.ScaleType.FIT_XY);

//        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        // создаем адаптер
        fillData();
        boxAdapter = new EventAdapter(context, eventAdap);

        // настраиваем список
        timetable_list.setAdapter(boxAdapter);
        initializeCalendar();

        return view;
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            eventAdap.add(new EventEntity("Product ", "sdf", "20.10.1195", R.drawable.avatar));
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void initializeCalendar() {
//        calendar = (CalendarView) findViewById(R.id.calendar);

        // sets whether to show the week number.
        calendar.setShowWeekNumber(false);

        // sets the first day of week according to Calendar.
        // here we set Monday as the first day of the Calendar
        calendar.setFirstDayOfWeek(2);

        //sets the listener to be notified upon selected date change.
        calendar.setOnDateChangeListener(new OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {

            }
        });
    }
}
