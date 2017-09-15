package dev.klippe.unity.network;

import dev.klippe.unity.requests.UserLoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Saeniel on 15.09.2017.
 */

public interface Api {

    public static final String host = "https://unitydev.minsvyazdnr.ru/";

    @POST("/user/login")
    Call<Boolean>auth(@Header("content-type") String format, @Body UserLoginRequest body);
}
