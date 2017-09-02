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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import dev.klippe.unity.adapter.EventAdapter;
import dev.klippe.unity.entity.EventEntity;
import dev.klippe.unity.utils.MaskImage;


public class AdsFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_ads;
    protected View view;
    private Context context;

    @BindView(R.id.searchTopImage)
    public ImageView searchImage;


    @BindView(R.id.lv_my_ads)
    public ListView lv_my_ads;

    @BindView(R.id.lv_other_ads)
    public ListView lv_other_ads;

    ArrayList<EventEntity> eventAdap = new ArrayList<EventEntity>();
    EventAdapter boxAdapter;
    String[] categories = new String[]{"1", "2"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        MaskImage mi = new MaskImage(context);
        searchImage.setImageBitmap(mi.getBitmap());
        searchImage.setScaleType(ImageView.ScaleType.FIT_XY);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, categories);

        // присваиваем адаптер списку
        lv_other_ads.setAdapter(adapter);

        fillData();
        boxAdapter = new EventAdapter(context, eventAdap);
        lv_my_ads.setAdapter(boxAdapter);
        return view;
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            eventAdap.add(new EventEntity("Product ", "sdf", "20.10.1195", R.drawable.avatar));
        }
    }


    public static AdsFragment getInstance(Context context) {
        Bundle args = new Bundle();
        AdsFragment fragment = new AdsFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
