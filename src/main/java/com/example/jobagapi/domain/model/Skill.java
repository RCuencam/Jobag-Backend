package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "skill")
public class Skill extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "skill_id", nullable = false)
//    @JsonIgnore
//    private ProfessionalProfile professionalProfile;
//    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })


    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    private String description;

    public Skill () {}

  //  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  //  @JoinColumn(name = "skill_id", nullable = false)
  //  @JsonIgnore
  //  private ProfessionalProfile professionalProfile;

    public Long getId() {
        return id;
    }

    public Skill setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Skill setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Skill setDescription(String description) {
        this.description = description;
        return this;
    }
}
