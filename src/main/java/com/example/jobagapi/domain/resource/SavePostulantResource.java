package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class SavePostulantResource {
    @NotNull
    private Long id;
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
    @NotNull
    private String document;
    @NotNull
    private Date birthday;
    @NotNull
    private String civil_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public SavePostulantResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SavePostulantResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SavePostulantResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public SavePostulantResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SavePostulantResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public SavePostulantResource setDocument(String document) {
        this.document = document;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public SavePostulantResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public SavePostulantResource setCivil_status(String civil_status) {
        this.civil_status = civil_status;
        return this;
    }
}
