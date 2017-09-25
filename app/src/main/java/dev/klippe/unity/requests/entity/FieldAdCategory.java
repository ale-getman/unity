
package dev.klippe.unity.requests.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldAdCategory {

    @SerializedName("target_id")
    @Expose
    private Integer targetId;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

}
