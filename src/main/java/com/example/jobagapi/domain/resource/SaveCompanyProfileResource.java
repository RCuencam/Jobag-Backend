package com.example.jobagapi.domain.resource;

import com.example.jobagapi.domain.model.Employeer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveCompanyProfileResource {
    @NotNull
    @NotBlank
    @Size(max = 40)
    private String direction;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String disctrict;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String city;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String country;

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
