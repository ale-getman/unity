package dev.klippe.unity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.klippe.unity.network.NetworkManager;
import dev.klippe.unity.network.data.request.Name;
import dev.klippe.unity.network.data.request.Mail;
import dev.klippe.unity.network.data.request.Pass;
import dev.klippe.unity.network.data.request.UserRegistrationRequest;
import dev.klippe.unity.network.data.response.UserRegistrationResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saeniel on 07.12.2017.
 */

public class SignUpActivity extends AppCompatActivity {

    NetworkManager networkManager;
    Context context;

    @BindView(R.id.btn_register)
    Button btnSignUp;

    @BindView(R.id.edt_reglogin)
    EditText edtLogin;

    @BindView(R.id.edt_regpass)
    EditText edtPass;

    @BindView(R.id.edt_regmail)
    EditText edtMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        networkManager = new NetworkManager();
        context = getApplicationContext();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                networkManager.getUnityApi().userRegister("application/json",
                        "json",
                        new UserRegistrationRequest(new Name(edtLogin.getText().toString()),
                                new Mail(edtMail.getText().toString()),
                                new Pass(edtPass.getText().toString()))).enqueue(new Callback<UserRegistrationResponse>() {
                    @Override
                    public void onResponse(Call<UserRegistrationResponse> call, Response<UserRegistrationResponse> response) {
                        if( response != null && response.body() != null) {
                            //TODO токен
                            Intent intent = new Intent(context, MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegistrationResponse> call, Throwable t) {

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
