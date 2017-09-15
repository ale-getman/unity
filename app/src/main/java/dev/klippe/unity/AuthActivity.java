package dev.klippe.unity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.network.Api;
import dev.klippe.unity.requests.UserLoginRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthActivity extends AppCompatActivity {

    private Call<Boolean> call;

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

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api api = new Retrofit.Builder()
                        .baseUrl(Api.host)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Api.class);

                call = api.auth("json", new UserLoginRequest(edtLogin.getText().toString(), edtPass.getText().toString()));
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Неверный логин или пароль",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        call.cancel();
    }
}
