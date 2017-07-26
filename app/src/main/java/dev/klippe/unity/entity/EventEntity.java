package dev.klippe.unity.entity;

/**
 * Created by klippe on 23.07.2017.
 */

public class EventEntity {
    public String nameEvent;
    public String descriprionEvent;
    public String dateEvent;
    public int imageEvent;

    public EventEntity(String nameEvent, String descriprionEvent, String dateEvent, int imageEvent) {
        this.nameEvent = nameEvent;
        this.descriprionEvent = descriprionEvent;
        this.dateEvent = dateEvent;
        this.imageEvent = imageEvent;
    }
}
