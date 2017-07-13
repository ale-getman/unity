package dev.klippe.unity.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.Toast;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;


public class EventFragment extends Fragment  {
    private static final int LAYOUT = R.layout.fragment_event;
    protected View view;
    private Context context;



    @BindView(R.id.listview)
    public ListView listview;
    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);
        listview = ButterKnife.findById(view, R.id.listview);
        SingleSelectToggleGroup   single = ButterKnife.findById(view, R.id.group_choices);



        single.setOnCheckedChangeListener(new SingleSelectToggleGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SingleSelectToggleGroup group, int checkedId) {
                Toast.makeText(context, "asd", Toast.LENGTH_SHORT).show();
            }
        });

       // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        listview.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_event, container, false);
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
