package com.example.jobagapi.resource;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class SaveUserResource {
    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private Long number;

    @NotNull
    private String password;

    private String document;

    public SaveUserResource (){
        super();
    }


    public SaveUserResource(@NotNull String firstname,  @NotNull String lastname,  @NotNull String email, @NotNull Long number, @NotNull String password, String document) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.password = password;
        this.document = document;
    }

    public String getFirstname() {
        return firstname;
    }

    public SaveUserResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveUserResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public SaveUserResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public SaveUserResource setDocument(String document) {
        this.document = document;
        return this;
    }
}
