package dev.klippe.unity.requests.entity;

/**
 * Created by Saeniel on 25.09.2017.
 */

public class EntityCreateRequest {
    int type;
    String title;

    public EntityCreateRequest(int type, String title) {
        this.type = type;
        this.title = title;
    }
}
