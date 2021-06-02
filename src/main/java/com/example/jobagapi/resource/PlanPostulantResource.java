package com.example.jobagapi.resource;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class PlanPostulantResource {
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

    public Long getId() {
        return id;
    }

    public PlanPostulantResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanPostulantResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getLimit_postulations() {
        return limit_postulations;
    }

    public PlanPostulantResource setLimit_postulations(int limit_postulations) {
        this.limit_postulations = limit_postulations;
        return this;
    }

    public int getLimit_videocreation() {
        return limit_videocreation;
    }

    public PlanPostulantResource setLimit_videocreation(int limit_videocreation) {
        this.limit_videocreation = limit_videocreation;
        return this;
    }

    public boolean isPre_design_templates() {
        return pre_design_templates;
    }

    public PlanPostulantResource setPre_design_templates(boolean pre_design_templates) {
        this.pre_design_templates = pre_design_templates;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public PlanPostulantResource setDuration(int duration) {
        this.duration = duration;
        return this;
    }
}
