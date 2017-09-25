
package dev.klippe.unity.requests.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntityCreateAdRequest {

    @SerializedName("type")
    @Expose
    private List<dev.klippe.unity.requests.entity.Type> type = null;
    @SerializedName("title")
    @Expose
    private List<dev.klippe.unity.requests.entity.Title> title = null;
    @SerializedName("field_address")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldAddress> fieldAddress = null;
    @SerializedName("field_coast")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldCoast> fieldCoast = null;
    @SerializedName("field_description")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldDescription> fieldDescription = null;
    @SerializedName("field_time")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldTime> fieldTime = null;
    @SerializedName("field_for_businessman")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldForBusinessman> fieldForBusinessman = null;
    @SerializedName("field_only_wholesale")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldOnlyWholesale> fieldOnlyWholesale = null;
    @SerializedName("field_imgs")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldImg> fieldImgs = null;
    @SerializedName("field_ad_category")
    @Expose
    private List<dev.klippe.unity.requests.entity.FieldAdCategory> fieldAdCategory = null;

    public List<dev.klippe.unity.requests.entity.Type> getType() {
        return type;
    }

    public void setType(List<dev.klippe.unity.requests.entity.Type> type) {
        this.type = type;
    }

    public List<dev.klippe.unity.requests.entity.Title> getTitle() {
        return title;
    }

    public void setTitle(List<dev.klippe.unity.requests.entity.Title> title) {
        this.title = title;
    }

    public List<dev.klippe.unity.requests.entity.FieldAddress> getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(List<dev.klippe.unity.requests.entity.FieldAddress> fieldAddress) {
        this.fieldAddress = fieldAddress;
    }

    public List<dev.klippe.unity.requests.entity.FieldCoast> getFieldCoast() {
        return fieldCoast;
    }

    public void setFieldCoast(List<dev.klippe.unity.requests.entity.FieldCoast> fieldCoast) {
        this.fieldCoast = fieldCoast;
    }

    public List<dev.klippe.unity.requests.entity.FieldDescription> getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(List<dev.klippe.unity.requests.entity.FieldDescription> fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public List<dev.klippe.unity.requests.entity.FieldTime> getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(List<dev.klippe.unity.requests.entity.FieldTime> fieldTime) {
        this.fieldTime = fieldTime;
    }

    public List<dev.klippe.unity.requests.entity.FieldForBusinessman> getFieldForBusinessman() {
        return fieldForBusinessman;
    }

    public void setFieldForBusinessman(List<dev.klippe.unity.requests.entity.FieldForBusinessman> fieldForBusinessman) {
        this.fieldForBusinessman = fieldForBusinessman;
    }

    public List<dev.klippe.unity.requests.entity.FieldOnlyWholesale> getFieldOnlyWholesale() {
        return fieldOnlyWholesale;
    }

    public void setFieldOnlyWholesale(List<dev.klippe.unity.requests.entity.FieldOnlyWholesale> fieldOnlyWholesale) {
        this.fieldOnlyWholesale = fieldOnlyWholesale;
    }

    public List<dev.klippe.unity.requests.entity.FieldImg> getFieldImgs() {
        return fieldImgs;
    }

    public void setFieldImgs(List<dev.klippe.unity.requests.entity.FieldImg> fieldImgs) {
        this.fieldImgs = fieldImgs;
    }

    public List<dev.klippe.unity.requests.entity.FieldAdCategory> getFieldAdCategory() {
        return fieldAdCategory;
    }

    public void setFieldAdCategory(List<dev.klippe.unity.requests.entity.FieldAdCategory> fieldAdCategory) {
        this.fieldAdCategory = fieldAdCategory;
    }

}
