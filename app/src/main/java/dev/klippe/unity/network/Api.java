package dev.klippe.unity.network;

import dev.klippe.unity.requests.entity.EntityCreateAdRequest;
import dev.klippe.unity.requests.entity.EntityCreateFeedbackRequest;
import dev.klippe.unity.requests.entity.EntityCreateRequest;
import dev.klippe.unity.requests.UserLoginRequest;
import dev.klippe.unity.requests.UserSignUpRequest;
import dev.klippe.unity.requests.file.FileCreateRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Saeniel on 15.09.2017.
 */

public interface Api {

    public static final String host = "https://unitydev.minsvyazdnr.ru/";

    @POST("/user/login")
    Call<Boolean>auth(@Header("content-type") String format, @Body UserLoginRequest body);

    @POST("/user/signup")
    Call<Boolean>signup(@Header("content-type") String format, @Body UserSignUpRequest body);

    @POST("entity/create")
    Call<Boolean>createEntity(@Header("content-type") String format, @Body EntityCreateRequest body);

    @POST("entity/create-ad")
    Call<Boolean>createEntityAd(@Header("content-type") String format, @Body EntityCreateAdRequest body);

    @POST("file/create")
    Call<Boolean>createFile(@Header("content-type") String format, @Body FileCreateRequest body);

    @POST("entity/create-feedback")
    Call<Boolean>createFeedback(@Header("content-type") String format, @Body EntityCreateFeedbackRequest body);

    /*@GET("/view-entity")
    Call<Void>viewEntity();*/
}
