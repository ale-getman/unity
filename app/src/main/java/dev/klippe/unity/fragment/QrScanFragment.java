package dev.klippe.unity.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.R;
import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;

/**
 * Created by user on 14.07.2017.
 */

public class QrScanFragment extends Fragment {

    private static final int LAYOUT = R.layout.qrscan_fragment;
    protected View view;
    private Context context;

    @BindView(R.id.camera_view)
    public SurfaceView mySurfaceView;

    public QREader qrEader;

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
        ButterKnife.bind(context, view);

        mySurfaceView = ButterKnife.findById(view ,R.id.camera_view);

        qrEader = new QREader.Builder(context, mySurfaceView, new QRDataListener() {
            @Override
            public void onDetected(final String data) {
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
                Log.d("QREader", "Value : " + data);
            }
        }).facing(QREader.BACK_CAM)
                .enableAutofocus(true)
                .height(mySurfaceView.getHeight())
                .width(mySurfaceView.getWidth())
                .build();

        qrEader.start();
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onResume() {
        super.onResume();
        qrEader.initAndStart(mySurfaceView);
        qrEader.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        qrEader.releaseAndCleanup();
    }
}
