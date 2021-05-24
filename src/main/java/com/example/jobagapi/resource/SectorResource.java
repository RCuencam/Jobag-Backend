package com.example.jobagapi.resource;

public class SectorResource {
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public SectorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SectorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SectorResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
