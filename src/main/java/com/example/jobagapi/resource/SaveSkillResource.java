package com.example.jobagapi.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveSkillResource {
    @Size(max = 50)
    private String name;
    @Size(max = 50)
    private String description;

    public String getName() {
        return name;
    }

    public SaveSkillResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSkillResource setDescription(String description) {
        this.description = description;
        return this;
    }

}
