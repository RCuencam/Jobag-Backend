package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "languages")
public class Languages extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    private Long level;

    public Long getId() {
        return id;
    }

    //Relacion
    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professional_profile", referencedColumnName = "id", nullable = false)
    private ProfessionalProfile professionalProfile;*/

    public Languages setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Languages setName(String name) {
        this.name = name;
        return this;
    }

    public Long getLevel() {
        return level;
    }

    public Languages setLevel(Long level) {
        this.level = level;
        return this;
    }
}
