package dev.klippe.unity.network;

import dev.klippe.unity.network.data.request.UserAuthorizationRequest;
import dev.klippe.unity.network.data.response.UserAuthorizationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Saeniel on 15.09.2017.
 */

public interface UnityApi {

    @POST("user/login")
    Call<UserAuthorizationResponse> userAuth(@Header("Content-Type")  String formatContent,
                                             @Query("_format") String format,
                                             @Body UserAuthorizationRequest body);
}
