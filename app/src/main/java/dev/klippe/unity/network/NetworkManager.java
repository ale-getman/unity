package dev.klippe.unity.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saeniel on 05.12.2017.
 */

public class NetworkManager {

    private String BASE_URL = "https://unity.tpz-clans.ru";
    private Retrofit retrofit;
    private UnityApi unityApi;

    public NetworkManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        unityApi = retrofit.create(UnityApi.class);
    }

    public UnityApi getUnityApi() {
        return unityApi;
    }
}
