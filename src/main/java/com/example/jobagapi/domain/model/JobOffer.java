package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "jobOffer")
public class JobOffer extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Employeer getEmployeer() {
        return employeer;
    }

    public JobOffer setEmployeer(Employeer employeer) {
        this.employeer = employeer;
        return this;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employeer employeer;
    @NotNull
    @Size(max = 200)
    private String description;
    @DateTimeFormat
    private LocalDate begin_date_offer;
    @DateTimeFormat
    private LocalDate final_date_offer;
    @NotNull
    private Long salary;
    @NotNull
    @Size(max = 60)
    private String direction;

    public Long getId() {
        return id;
    }

    public JobOffer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobOffer setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getBegin_date_offer() {
        return begin_date_offer;
    }

    public JobOffer setBegin_date_offer(LocalDate begin_date_offer) {
        this.begin_date_offer = begin_date_offer;
        return this;
    }

    public LocalDate getFinal_date_offer() {
        return final_date_offer;
    }

    public JobOffer setFinal_date_offer(LocalDate final_date_offer) {
        this.final_date_offer = final_date_offer;
        return this;
    }

    public Long getSalary() {
        return salary;
    }

    public JobOffer setSalary(Long salary) {
        this.salary = salary;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public JobOffer setDirection(String direction) {
        this.direction = direction;
        return this;
    }
}
