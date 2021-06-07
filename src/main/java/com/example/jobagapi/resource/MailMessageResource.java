package com.example.jobagapi.resource;

public class MailMessageResource {
    Long id;
    String message;
    String document_Link;

    public Long getId() {
        return id;
    }

    public MailMessageResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MailMessageResource setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDocument_Link() {
        return document_Link;
    }

    public MailMessageResource setDocument_Link(String document_Link) {
        this.document_Link = document_Link;
        return this;
    }
}
