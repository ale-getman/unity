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
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;

/**
 * Created by user on 13.07.2017.
 */

public class AddAdFragment extends Fragment {

    private static final int LAYOUT = R.layout.fragment_addad;
    protected View view;
    private Context context;

    @BindView(R.id.addad_add_btn)
    public ImageButton addad_add_btn;
    @BindView(R.id.addad_title_edit)
    public EditText addad_title_edit;
    @BindView(R.id.addad_map_btn)
    public Button addad_map_btn;
    @BindView(R.id.addad_description_txt)
    public TextView addad_description_txt;
    @BindView(R.id.addad_description_multitext)
    public EditText addad_description_multitext;
    @BindView(R.id.addad_photo_grid)
    public GridView addad_photo_grid;
    @BindView(R.id.addad_cost_edit)
    public EditText addad_cost_edit;
    @BindView(R.id.addad_send_btn)
    public Button addad_send_btn;

    public static AddAdFragment getInstance(Context context) {
        Bundle args = new Bundle();
        AddAdFragment fragment = new AddAdFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
