package com.example.jobagapi.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveSectorResource {
    private String name;
    @Size(max = 70)
    private String description;

    public String getName() {
        return name;
    }

    public SaveSectorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSectorResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
