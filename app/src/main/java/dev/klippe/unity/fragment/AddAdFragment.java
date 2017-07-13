package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import dev.klippe.unity.R;

/**
 * Created by user on 13.07.2017.
 */

public class AddAdFragment extends Fragment {

    private static final int LAYOUT = R.layout.addad_fragment;
    protected View view;
    private Context context;

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
        ButterKnife.bind(context, view);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
