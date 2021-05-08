package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.AuditModel;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class EmployeerResource extends AuditModel {

    public Long id;
    public String posicion;
    private String firstname;
    private String lastname;
    private String email;
    private Long number;
    private String password;

    public Long getId() {
        return id;
    }

    public EmployeerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPosicion() {
        return posicion;
    }

    public EmployeerResource setPosicion(String posicion) {
        this.posicion = posicion;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public EmployeerResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public EmployeerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public EmployeerResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmployeerResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
