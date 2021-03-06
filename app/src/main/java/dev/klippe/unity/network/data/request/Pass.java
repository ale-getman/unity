
package dev.klippe.unity.network.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pass {

    @SerializedName("value")
    @Expose
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Pass(String value) {
        this.value = value;
    }
}
