package dev.klippe.unity.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import dev.klippe.unity.AuthActivity;
import dev.klippe.unity.EventActivity;
import dev.klippe.unity.MainActivity;
import dev.klippe.unity.R;
import dev.klippe.unity.adapter.EventAdapter;
import dev.klippe.unity.entity.EventEntity;
import dev.klippe.unity.utils.DialogCustom;
import dev.klippe.unity.utils.MaskImage;


public class MainFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_main;
    protected View view;
    private Context context;

    @BindView(R.id.main_greetings)
    public TextView mainGreetings;

    @BindView(R.id.main_avatar)
    public CircleImageView mainAvatar;

    @BindView(R.id.main_img)
    public ImageView searchImage;

    @BindView(R.id.main_points)
    public TextView mainPoints;

    @BindView(R.id.main_switch)
    public TextView mainSwitch;

    @BindView(R.id.main_near)
    public TextView mainNear;

    @BindView(R.id.main_rec)
    public TextView mainRec;

    @BindView(R.id.main_onmap)
    public TextView mainOnmap;

    @BindView(R.id.main_list)
    public ListView listView;

    ArrayList<EventEntity> eventAdap = new ArrayList<EventEntity>();
    EventAdapter boxAdapter;

    public boolean switcher;
    public String buf;

    public SingleSelectToggleGroup single;
    String[] names = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);

        MaskImage mi = new MaskImage(context);
        searchImage.setImageBitmap(mi.getBitmap());
        searchImage.setScaleType(ImageView.ScaleType.FIT_XY);

        // создаем адаптер
        fillData();
        boxAdapter = new EventAdapter(context, eventAdap);

        // настраиваем список
        listView.setAdapter(boxAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                startActivity(intent);

            }
        });

        mainGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogCustom dc = new DialogCustom();
                dc.showDialog(context, "Test test test test test test test Test test test test test test test Test test test test test test test");
            }
        });

        mainAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft ;
                ft = getFragmentManager().beginTransaction();
                ProfileFragment profileFragment = ProfileFragment.getInstance(context);
                ft.replace(R.id.main_frame, profileFragment);
                ft.commit();
            }
        });

        buf = "<font color='red'>880</font><br>БАЛЛОВ";
        mainPoints.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
        buf = "<font color='red'> Мероприятия </font> | Новости";
        switcher = true;
//        mainSwitch.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);

        /*mainSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switcher) {
                    buf = "Мероприятия | <font color='red'> Новости </font>";
                    mainNear.setText("Сегодня");
                    mainRec.setText("Вчера");
                    mainOnmap.setText("Ранее");
                    mainSwitch.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
                    switcher = false;
                } else {
                    buf = "<font color='red'> Мероприятия </font> | Новости";
                    mainNear.setText("Ближайшие");
                    mainRec.setText("Рекомендации");
                    mainOnmap.setText("На карте");
                    mainSwitch.setText(Html.fromHtml(buf), TextView.BufferType.SPANNABLE);
                    switcher = true;
                }
            }
        });*/

        return view;
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            eventAdap.add(new EventEntity("Product ", "sdf", "20.10.1195", R.drawable.avatar));
        }
    }

    public static MainFragment getInstance(Context context) {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
