package com.example.jobagapi.resource;

import javax.validation.constraints.Size;

public class SaveLanguaguesResource {
    @Size(max = 30)
    private String name;
    private Long level;

    public String getName() {
        return name;
    }

    public SaveLanguaguesResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public SaveLanguaguesResource setLevel(Long level) {
        this.level = level;
        return this;
    }
}
