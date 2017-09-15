package dev.klippe.unity.requests;

/**
 * Created by Saeniel on 15.09.2017.
 */

public class UserLoginRequest {
    String name;
    String pass;

    public UserLoginRequest(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
