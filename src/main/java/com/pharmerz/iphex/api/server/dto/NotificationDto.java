package com.pharmerz.iphex.api.server.dto;

/**
 * Created by ankur on 04-10-2016.
 */
public class NotificationDto {
    private String subject;
    private String body;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public NotificationDto() {
    }

    public NotificationDto(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }
}
