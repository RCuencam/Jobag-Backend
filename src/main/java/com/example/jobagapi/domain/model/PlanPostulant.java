package com.example.jobagapi.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="planspostulant")
public class PlanPostulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Length(max = 50)
    private String description;

    @NotNull
    private int limit_postulations;

    @NotNull
    private int limit_videocreation;

    @NotNull
    private boolean pre_design_templates;

    @NotNull
    private int duration;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Postulant postulant;

    public PlanPostulant(Long id,String description, int limit_postulations, int limit_videocreation, boolean pre_design_templates, int duration, Postulant postulant) {
        this.id = id;
        this.description = description;
        this.limit_postulations = limit_postulations;
        this.limit_videocreation = limit_videocreation;
        this.pre_design_templates = pre_design_templates;
        this.duration = duration;
        this.postulant = postulant;
    }

    public PlanPostulant() {

    }

    public Long getId() {
        return id;
    }

    public PlanPostulant setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanPostulant setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getLimit_postulations() {
        return limit_postulations;
    }

    public PlanPostulant setLimit_postulations(int limit_postulations) {
        this.limit_postulations = limit_postulations;
        return this;
    }

    public int getLimit_videocreation() {
        return limit_videocreation;
    }

    public PlanPostulant setLimit_videocreation(int limit_videocreation) {
        this.limit_videocreation = limit_videocreation;
        return this;
    }

    public boolean isPre_design_templates() {
        return pre_design_templates;
    }

    public PlanPostulant setPre_design_templates(boolean pre_design_templates) {
        this.pre_design_templates = pre_design_templates;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public PlanPostulant setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public PlanPostulant setPostulant(Postulant postulant) {
        this.postulant = postulant;
        return this;
    }
}
