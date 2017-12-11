package dev.klippe.unity.network;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import dev.klippe.unity.network.data.request.UserAuthorizationRequest;
import dev.klippe.unity.network.data.request.UserRegistrationRequest;
import dev.klippe.unity.network.data.response.UserAuthorizationResponse;
import dev.klippe.unity.network.data.response.UserRegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Saeniel on 15.09.2017.
 */

public interface UnityApi {

    @POST("user/login")
    Call<UserAuthorizationResponse> userAuth(@Header("content-type")  String formatContent,
                                             @Query("_format") String format,
                                             @Body UserAuthorizationRequest body);

    @POST("user/register")
    Call<UserRegistrationResponse> userRegister(@Header("content-type") String formatContent,
                                                @Query("_format") String format,
                                                @Body UserRegistrationRequest body);

}
