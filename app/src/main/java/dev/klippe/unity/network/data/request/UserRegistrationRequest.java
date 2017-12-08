
package dev.klippe.unity.network.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import dev.klippe.unity.network.data.request.Mail;
import dev.klippe.unity.network.data.request.Name;
import dev.klippe.unity.network.data.request.Pass;

public class UserRegistrationRequest {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("mail")
    @Expose
    private Mail mail;
    @SerializedName("pass")
    @Expose
    private Pass pass;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public UserRegistrationRequest(Name name, Mail mail, Pass pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }
}
