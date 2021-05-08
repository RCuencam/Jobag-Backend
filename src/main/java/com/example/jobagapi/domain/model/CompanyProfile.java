package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "company_profile")
public class CompanyProfile extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "companyProfile")
    private Employeer employeer;

    @NotNull
    private String direction;

    @NotNull
    private String disctrict;

    @NotNull
    private String city;

    @NotNull
    private String country;



    public Long getId() {
        return id;
    }

    public CompanyProfile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public CompanyProfile setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getDisctrict() {
        return disctrict;
    }

    public CompanyProfile setDisctrict(String disctrict) {
        this.disctrict = disctrict;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CompanyProfile setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CompanyProfile setCountry(String country) {
        this.country = country;
        return this;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }
}
