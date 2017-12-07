
package dev.klippe.unity.network.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Path {

    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("pid")
    @Expose
    private Object pid;
    @SerializedName("langcode")
    @Expose
    private Object langcode;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public Object getLangcode() {
        return langcode;
    }

    public void setLangcode(Object langcode) {
        this.langcode = langcode;
    }

}
