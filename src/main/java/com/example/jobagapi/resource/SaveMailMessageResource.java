package com.example.jobagapi.resource;

import javax.validation.constraints.Size;

public class SaveMailMessageResource {
    String message;
    @Size(max = 40)
    String document_Link;

    public String getMessage() {
        return message;
    }

    public SaveMailMessageResource setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDocument_Link() {
        return document_Link;
    }

    public SaveMailMessageResource setDocument_Link(String document_Link) {
        this.document_Link = document_Link;
        return this;
    }
}

