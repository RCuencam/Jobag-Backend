package com.example.jobagapi.domain.resource;

import javax.validation.constraints.NotNull;

public class SaveUserResource {

    @NotNull
    public Long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String email;
    @NotNull
    private Long number;
    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
