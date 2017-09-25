
package dev.klippe.unity.requests.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldForBusinessman {

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
