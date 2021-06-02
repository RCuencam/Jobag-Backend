package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Postulant extends User{
    private String civil_status;

    public Postulant(){
        super();
    }
    public Postulant(Long id,  @NotNull String firstname,  @NotNull String lastname,  @NotNull String email, @NotNull Long number, @NotNull String password, String document,String civil_status) {
        super(id, firstname, lastname, email, number, password, document);
        this.civil_status = civil_status;

    }

    public String getCivil_status() {
        return civil_status;
    }

    public Postulant setCivil_status(String civil_status) {
        this.civil_status = civil_status;
        return this;
    }

}

