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

    public void setId(Long id) {
        this.id = id;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDisctrict() {
        return disctrict;
    }

    public void setDisctrict(String disctrict) {
        this.disctrict = disctrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
