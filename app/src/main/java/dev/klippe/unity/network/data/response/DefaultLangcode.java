
package dev.klippe.unity.network.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultLangcode {

    @SerializedName("value")
    @Expose
    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

}
