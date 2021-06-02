package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String document;
    public User (){
        super();
    }

    public User(Long id,  @NotNull String firstname,  @NotNull String lastname,  @NotNull String email, @NotNull Long number, @NotNull String password, String document) {
       super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.number = number;
        this.password = password;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getNumber() {
        return number;
    }

    public User setNumber(Long number) {
        this.number = number;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public User setDocument(String document) {
        this.document = document;
        return this;
    }
}
