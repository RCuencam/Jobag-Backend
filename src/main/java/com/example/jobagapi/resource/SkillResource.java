package com.example.jobagapi.resource;

public class SkillResource{
    public Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public SkillResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SkillResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SkillResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
