package dev.klippe.unity.adapter;

import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.klippe.unity.R;
import dev.klippe.unity.entity.CityCategory;

/**
 * Created by klippe on 23.07.2017.
 */

public class CategoryAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<CityCategory> objects;


    public CategoryAdapter(Context context, ArrayList<CityCategory> categories) {
        ctx = context;
        objects = categories;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_catalog_listview, parent, false);
        }

        CityCategory p = getCategory(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.txt_category)).setText(p.nameCategory);
        ((ImageView) view.findViewById(R.id.im_category)).setImageResource(p.imageCategory);


        return view;
    }

    // товар по позиции
    CityCategory getCategory(int position) {
        return ((CityCategory) getItem(position));
    }


}
