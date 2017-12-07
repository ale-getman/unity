
package dev.klippe.unity.network.data.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegistrationResponse {

    @SerializedName("uid")
    @Expose
    private List<Uid> uid = null;
    @SerializedName("uuid")
    @Expose
    private List<Uuid> uuid = null;
    @SerializedName("langcode")
    @Expose
    private List<Langcode> langcode = null;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;
    @SerializedName("created")
    @Expose
    private List<Created> created = null;
    @SerializedName("changed")
    @Expose
    private List<Changed> changed = null;
    @SerializedName("default_langcode")
    @Expose
    private List<DefaultLangcode> defaultLangcode = null;
    @SerializedName("path")
    @Expose
    private List<Path> path = null;
    @SerializedName("user_picture")
    @Expose
    private List<Object> userPicture = null;

    public List<Uid> getUid() {
        return uid;
    }

    public void setUid(List<Uid> uid) {
        this.uid = uid;
    }

    public List<Uuid> getUuid() {
        return uuid;
    }

    public void setUuid(List<Uuid> uuid) {
        this.uuid = uuid;
    }

    public List<Langcode> getLangcode() {
        return langcode;
    }

    public void setLangcode(List<Langcode> langcode) {
        this.langcode = langcode;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Created> getCreated() {
        return created;
    }

    public void setCreated(List<Created> created) {
        this.created = created;
    }

    public List<Changed> getChanged() {
        return changed;
    }

    public void setChanged(List<Changed> changed) {
        this.changed = changed;
    }

    public List<DefaultLangcode> getDefaultLangcode() {
        return defaultLangcode;
    }

    public void setDefaultLangcode(List<DefaultLangcode> defaultLangcode) {
        this.defaultLangcode = defaultLangcode;
    }

    public List<Path> getPath() {
        return path;
    }

    public void setPath(List<Path> path) {
        this.path = path;
    }

    public List<Object> getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(List<Object> userPicture) {
        this.userPicture = userPicture;
    }

}
