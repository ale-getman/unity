package dev.klippe.unity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.klippe.unity.R;
import dev.klippe.unity.entity.CityCategory;
import dev.klippe.unity.entity.EventEntity;

/**
 * Created by klippe on 23.07.2017.
 */

public class EventAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<EventEntity> objects;


    public EventAdapter(Context context, ArrayList<EventEntity> categories) {
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
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        EventEntity p = getCategory(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.txt_name_event)).setText(p.nameEvent);
        ((TextView) view.findViewById(R.id.txt_description_event)).setText(p.descriprionEvent);
        ((TextView) view.findViewById(R.id.txt_date_event)).setText(p.dateEvent);
        ((ImageView) view.findViewById(R.id.img_event)).setImageResource(p.imageEvent);


        return view;
    }

    // товар по позиции
    EventEntity getCategory(int position) {
        return ((EventEntity) getItem(position));
    }


}
