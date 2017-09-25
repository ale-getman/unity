
package dev.klippe.unity.requests.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldDescription {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("format")
    @Expose
    private String format;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
