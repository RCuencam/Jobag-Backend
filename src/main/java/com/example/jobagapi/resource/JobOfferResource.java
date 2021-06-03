package com.example.jobagapi.resource;

import java.time.LocalDate;

public class JobOfferResource {
    private Long id;
    private String description;
    private LocalDate begin_date_offer;
    private LocalDate final_date_offer;
    private Long salary;
    private String direction;

    public Long getId() {
        return id;
    }

    public JobOfferResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobOfferResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getBegin_date_offer() {
        return begin_date_offer;
    }

    public JobOfferResource setBegin_date_offer(LocalDate begin_date_offer) {
        this.begin_date_offer = begin_date_offer;
        return this;
    }

    public LocalDate getFinal_date_offer() {
        return final_date_offer;
    }

    public JobOfferResource setFinal_date_offer(LocalDate final_date_offer) {
        this.final_date_offer = final_date_offer;
        return this;
    }

    public Long getSalary() {
        return salary;
    }

    public JobOfferResource setSalary(Long salary) {
        this.salary = salary;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public JobOfferResource setDirection(String direction) {
        this.direction = direction;
        return this;
    }
}
