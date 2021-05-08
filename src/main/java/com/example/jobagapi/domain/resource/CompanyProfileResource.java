package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.AuditModel;
import com.example.jobagapi.domain.model.Employeer;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CompanyProfileResource extends AuditModel {
    private Long id;
    private Employeer employeer;
    private String direction;
    private String disctrict;
    private String city;
    private String country;

    public Long getId() {
        return id;
    }

    public CompanyProfileResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public CompanyProfileResource setEmployeer(Employeer employeer) {
        this.employeer = employeer;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public CompanyProfileResource setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getDisctrict() {
        return disctrict;
    }

    public CompanyProfileResource setDisctrict(String disctrict) {
        this.disctrict = disctrict;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CompanyProfileResource setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CompanyProfileResource setCountry(String country) {
        this.country = country;
        return this;
    }
}
