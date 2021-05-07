package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")

public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="id")
    private Long id;  //SOLOID
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="postulant_id",referencedColumnName = "id")
    private Postulant postulant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="employeer_id",referencedColumnName = "id")
    private Employeer employeer;

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




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }
}
