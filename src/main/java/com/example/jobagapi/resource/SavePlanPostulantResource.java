package com.example.jobagapi.resource;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class SavePlanPostulantResource {

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

    public String getDescription() {
        return description;
    }

    public SavePlanPostulantResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getLimit_postulations() {
        return limit_postulations;
    }

    public SavePlanPostulantResource setLimit_postulations(int limit_postulations) {
        this.limit_postulations = limit_postulations;
        return this;
    }

    public int getLimit_videocreation() {
        return limit_videocreation;
    }

    public SavePlanPostulantResource setLimit_videocreation(int limit_videocreation) {
        this.limit_videocreation = limit_videocreation;
        return this;
    }

    public boolean isPre_design_templates() {
        return pre_design_templates;
    }

    public SavePlanPostulantResource setPre_design_templates(boolean pre_design_templates) {
        this.pre_design_templates = pre_design_templates;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SavePlanPostulantResource setDuration(int duration) {
        this.duration = duration;
        return this;
    }
}
