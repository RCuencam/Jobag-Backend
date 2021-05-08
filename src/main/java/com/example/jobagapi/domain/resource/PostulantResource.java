package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.AuditModel;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostulantResource extends AuditModel {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long number;
    private String password;
    private String document;
    private Date birthday;
    private String civil_status;


    public Long getId() {
        return id;
    }

    public PostulantResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public PostulantResource setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public PostulantResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PostulantResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public PostulantResource setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PostulantResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public PostulantResource setDocument(String document) {
        this.document = document;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public PostulantResource setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public PostulantResource setCivil_status(String civil_status) {
        this.civil_status = civil_status;
        return this;
    }
}
