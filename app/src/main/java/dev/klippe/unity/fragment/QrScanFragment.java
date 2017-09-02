package dev.klippe.unity.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;

/**
 * Created by user on 14.07.2017.
 */

public class QrScanFragment extends Fragment {

    private static final int LAYOUT = R.layout.fragment_qrscan;
    protected View view;
    private Context context;
    public String toast;

    @BindView(R.id.qrscan_info)
    public TextView qrscanInfo;

    @BindView(R.id.qrscan_start)
    public Button qrscanStart;

    public static QrScanFragment getInstance(Context context) {
        Bundle args = new Bundle();
        QrScanFragment fragment = new QrScanFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        qrscanStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanFromFragment();
            }
        });

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void scanFromFragment() {
        IntentIntegrator.forSupportFragment(this)
                .setPrompt("")
                .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
                .setOrientationLocked(false)
                .initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                toast = "Cancelled from fragment";
            } else {
                toast = "Scanned from fragment: " + result.getContents();
            }
            // At this point we may or may not have a reference to the activity
            displayToast();
        }
    }

    private void displayToast() {
        if (getActivity() != null && toast != null) {
            Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            qrscanInfo.setText(toast);
            toast = null;
        }
    }
}
