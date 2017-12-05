package dev.klippe.unity.network.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Saeniel on 05.12.2017.
 */

public class UserAuthorizationResponse {

    @SerializedName("current_user")
    @Expose
    private CurrentUser currentUser;
    @SerializedName("csrf_token")
    @Expose
    private String csrfToken;
    @SerializedName("logout_token")
    @Expose
    private String logoutToken;

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    public String getLogoutToken() {
        return logoutToken;
    }

    public void setLogoutToken(String logoutToken) {
        this.logoutToken = logoutToken;
    }

}