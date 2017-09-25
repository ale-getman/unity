package dev.klippe.unity.requests;

/**
 * Created by Saeniel on 25.09.2017.
 */

public class UserSignUpRequest {
    String name;
    String pass;
    String mail;

    public UserSignUpRequest(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }
}
