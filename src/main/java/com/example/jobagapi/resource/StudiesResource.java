package com.example.jobagapi.resource;

public class StudiesResource {
    private Long id;
    private String name;
    private Long degree;

    public Long getId() {
        return id;
    }

    public StudiesResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudiesResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getDegree() {
        return degree;
    }

    public StudiesResource setDegree(Long degree) {
        this.degree = degree;
        return this;
    }
}
