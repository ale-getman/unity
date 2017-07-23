package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import dev.klippe.unity.adapter.CategoryAdapter;
import dev.klippe.unity.adapter.EventAdapter;
import dev.klippe.unity.entity.CityCategory;
import dev.klippe.unity.entity.EventEntity;
import dev.klippe.unity.utils.MaskImage;


public class EventFragment extends Fragment  {
    private static final int LAYOUT = R.layout.fragment_event;
    protected View view;
    private Context context;

    @BindView(R.id.imageView)
    public ImageView searchImage;

    ArrayList<EventEntity> eventAdap = new ArrayList<EventEntity>();
    EventAdapter boxAdapter;



    public SingleSelectToggleGroup   single;
    public ListView listview;
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);
        listview = (ListView) view.findViewById(R.id.listview2);


        searchImage = ButterKnife.findById(view, R.id.imageView);
        MaskImage mi = new MaskImage(context);
        searchImage.setImageBitmap(mi.getBitmap());
        searchImage.setScaleType(ImageView.ScaleType.FIT_XY);


        // создаем адаптер
        fillData();
        boxAdapter = new EventAdapter(context, eventAdap);

        // настраиваем список

        listview.setAdapter(boxAdapter);

        return view;
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            eventAdap.add(new EventEntity("Product ","sdf","20.10.1195",R.drawable.avatar));
        }
    }

    public static EventFragment getInstance(Context context) {
        Bundle args = new Bundle();
        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
