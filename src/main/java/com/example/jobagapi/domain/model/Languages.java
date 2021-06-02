package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "languages")
public class Languages extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    private Long level;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "languages")
    private List<ProfessionalProfile> professionalprofiles;

    public Long getId() {
        return id;
    }

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

    public List<ProfessionalProfile> getProfessionalprofiles() {
        return professionalprofiles;
    }

    public void setProfessionalprofiles(List<ProfessionalProfile> professionalprofiles) {
        this.professionalprofiles = professionalprofiles;
    }
}
