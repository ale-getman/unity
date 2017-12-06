package dev.klippe.unity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.network.NetworkManager;
import dev.klippe.unity.network.data.request.UserAuthorizationRequest;
import dev.klippe.unity.network.data.response.UserAuthorizationResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    Context context;
    NetworkManager networkManager;
    SharedPreferences sPref;
    public static final String myPrefs = "myprefs";
    public static final String nameKey = "token";

    @BindView(R.id.btn_singin)
    Button btnSingIn;

    @BindView(R.id.et_login)
    EditText edtLogin;

    @BindView(R.id.et_password)
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sPref = getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        if (sPref.contains(nameKey)) {
            String prToken = sPref.getString(nameKey, "");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        context = getApplicationContext();
        networkManager = new NetworkManager();

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                networkManager.getUnityApi().userAuth("application/json",
                        "json", new UserAuthorizationRequest(edtLogin.getText().toString(),
                                edtPass.getText().toString())).enqueue(new Callback<UserAuthorizationResponse>() {
                    @Override
                    public void onResponse(Call<UserAuthorizationResponse> call, Response<UserAuthorizationResponse> response) {
                        if( response != null && response.body() != null) {
                            String token = response.body().getCsrfToken();
                            SharedPreferences.Editor editor = sPref.edit();
                            editor.putString(nameKey, token);
                            editor.apply();
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserAuthorizationResponse> call, Throwable t) {

                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
