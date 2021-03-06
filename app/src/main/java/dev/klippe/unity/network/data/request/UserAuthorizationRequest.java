package dev.klippe.unity.network.data.request;

/**
 * Created by Saeniel on 04.12.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAuthorizationRequest {

    @SerializedName("name")
    private String name;
    @SerializedName("pass")
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UserAuthorizationRequest(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
