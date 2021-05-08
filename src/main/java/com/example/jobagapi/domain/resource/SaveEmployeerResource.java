package com.example.jobagapi.domain.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveEmployeerResource {
    @NotNull
    public String posicion;

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

    public String getPosicion() {
        return posicion;
    }

    public SaveEmployeerResource setPosicion(String posicion) {
        this.posicion = posicion;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public SaveEmployeerResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveEmployeerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveEmployeerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public SaveEmployeerResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveEmployeerResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
