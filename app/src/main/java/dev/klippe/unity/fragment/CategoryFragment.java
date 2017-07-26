package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import dev.klippe.unity.adapter.CategoryAdapter;
import dev.klippe.unity.entity.CityCategory;
import dev.klippe.unity.utils.MaskImage;


public class CategoryFragment extends Fragment  {
    private static final int LAYOUT = R.layout.fragment_category;
    protected View view;
    private Context context;



    public SingleSelectToggleGroup   single;
    public ListView listview;
    @BindView(R.id.searchTopImage)
    public ImageView searchImage;

    ArrayList<CityCategory> products = new ArrayList<CityCategory>();
    CategoryAdapter boxAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);

        listview = (ListView) view.findViewById(R.id.lv_category);

       ImageView searchImage = ButterKnife.findById(view, R.id.searchTopImage);
        MaskImage mi = new MaskImage(context);
        searchImage.setImageBitmap(mi.getBitmap());
        searchImage.setScaleType(ImageView.ScaleType.FIT_XY);

        // создаем адаптер
        fillData();
        boxAdapter = new CategoryAdapter(context, products);

        // настраиваем список

        listview.setAdapter(boxAdapter);



        return view;
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new CityCategory("Product ",R.drawable.avatar));
        }
    }

    public static CategoryFragment getInstance(Context context) {
        Bundle args = new Bundle();
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
