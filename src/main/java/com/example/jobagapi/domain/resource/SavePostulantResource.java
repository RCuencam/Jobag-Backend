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
    @NotBlank
    private String document;
    @NotNull
    @NotBlank
    private Date birthday;
    @Null
    private String civil_status;

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
