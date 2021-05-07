package com.example.jobagapi.domain.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveEmployeerResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    public String posicion;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String firstname;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String lastname;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private Long number;

    @NotNull
    @NotBlank
    @Size(max = 20)
    private String password;

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
