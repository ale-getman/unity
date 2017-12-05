package dev.klippe.unity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.network.NetworkManager;
import dev.klippe.unity.network.data.request.UserAuthorizationRequest;
import dev.klippe.unity.network.data.response.UserAuthorizationResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    NetworkManager networkManager;
    SharedPreferences sPref;
    final String UNITY_USER = "";
    public String cookie;

    @BindView(R.id.btn_singin)
    Button btnSingIn;

    @BindView(R.id.et_login)
    EditText edtLogin;

    @BindView(R.id.et_password)
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        networkManager = new NetworkManager();

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                networkManager.getUnityApi().userAuth("application/json",
                        "json", new UserAuthorizationRequest(edtLogin.toString(),
                                edtPass.toString())).enqueue(new Callback<UserAuthorizationResponse>() {
                    @Override
                    public void onResponse(Call<UserAuthorizationResponse> call, Response<UserAuthorizationResponse> response) {
                        if( response != null && response.body() != null) {
                            cookie = response.body().getCsrfToken();
                            saveToPreferences(cookie);
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

    void saveToPreferences(String text) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(UNITY_USER, text);
        ed.commit();
    }

}
