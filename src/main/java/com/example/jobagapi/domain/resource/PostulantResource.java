package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.AuditModel;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostulantResource extends AuditModel {

    private Long id;
    private User user;
    private ProfessionalProfile profesionalId;
    private String document;
    private Date birthday;
    private String civil_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProfessionalProfile getProfesionalId() {
        return profesionalId;
    }

    public void setProfesionalId(ProfessionalProfile profesionalId) {
        this.profesionalId = profesionalId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }
}
