
package dev.klippe.unity.requests.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EntityCreateFeedbackRequest {

    @SerializedName("webform_id")
    @Expose
    private String webformId;
    @SerializedName("feedback_text")
    @Expose
    private String feedbackText;

    public String getWebformId() {
        return webformId;
    }

    public void setWebformId(String webformId) {
        this.webformId = webformId;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

}
