package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;

/**
 * Created by user on 13.07.2017.
 */

public class AddEventFragment extends Fragment {

    private static final int LAYOUT = R.layout.addevent_fragment;
    protected View view;
    private Context context;

    @BindView(R.id.addevent_add_btn)
    public ImageButton addevent_add_btn;
    @BindView(R.id.addevent_title_edit)
    public EditText addevent_title_edit;
    @BindView(R.id.addevent_map_btn)
    public Button addevent_map_btn;
    @BindView(R.id.addevent_date_btn)
    public Button addevent_date_btn;
    @BindView(R.id.addevent_description_txt)
    public TextView addevent_description_txt;
    @BindView(R.id.addevent_description_multitext)
    public EditText addevent_description_multitext;
    @BindView(R.id.addevent_cost_edit)
    public EditText addevent_cost_edit;
    @BindView(R.id.addevent_send_btn)
    public Button addevent_send_btn;

    public static AddEventFragment getInstance(Context context) {
        Bundle args = new Bundle();
        AddEventFragment fragment = new AddEventFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(context, view);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
