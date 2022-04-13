package com.mail.gl.mail_provider.model;

import java.util.Date;

public class Email {
    private String uuid;
    private String from;
    private String to;
    private String message;
    private String objet;
    private Date createdAt;
    public Email(){

    }
    public Email(String from, String to, String message, String objet, Date createdAt) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.objet = objet;
        this.createdAt = createdAt;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
