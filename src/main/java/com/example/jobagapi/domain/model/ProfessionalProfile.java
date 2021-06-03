package com.example.jobagapi.domain.model;


import com.example.jobagapi.domain.model.Studies;
import com.example.jobagapi.domain.model.Languages;
import com.example.jobagapi.domain.model.Skill;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "professional_profile")
public class ProfessionalProfile{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Length(max = 100)
    private String ocupation;

    private String video;

    @NotNull
    @Length(max = 100)
    private String description;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postulant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Postulant postulant;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="professionalprofile_skills",
            joinColumns =  {@JoinColumn(name = "professionalprofile_id")},
            inverseJoinColumns = {@JoinColumn(name = "skills_id")})
    private List<Skill> skills;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="professionalprofile_languages",
            joinColumns =  {@JoinColumn(name = "professionalprofile_id")},
            inverseJoinColumns = {@JoinColumn(name = "languages_id")})
    private List<Languages> languages;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name ="professionalprofile_studies",
            joinColumns =  {@JoinColumn(name = "professionalprofile_id")},
            inverseJoinColumns = {@JoinColumn(name = "studies_id")})
    private List<Studies> studies;


    public ProfessionalProfile(Long id, String ocupation, String video, String description, Postulant postulant, Studies studies, Skill skill, Languages languages) {
        this.id = id;
        this.ocupation = ocupation;
        this.video = video;
        this.description = description;
        this.postulant = postulant;
    }

    public ProfessionalProfile() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public void setPostulant(Postulant postulant) {
        this.postulant = postulant;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public boolean hasSkill(Skill skill) {
        return this.getSkills().contains(skill);
    }

    public ProfessionalProfile addSkill(Skill skill) {
        if(!hasSkill(skill)) {
            this.getSkills().add(skill);
        }
        return this;
    }

    public ProfessionalProfile removeSkill(Skill skill) {
        if (this.hasSkill(skill))
            this.getSkills().remove(skill);
        return this;
    }

    public boolean hasStudies(Studies studies) {
        return this.getStudies().contains(studies);
    }

    public ProfessionalProfile addStudies(Studies studies) {
        if(!hasStudies(studies)) {
            this.getStudies().add(studies);
        }
        return this;
    }

    public ProfessionalProfile removeStudies(Studies studies) {
        if (this.hasStudies(studies))
            this.getStudies().remove(studies);
        return this;
    }

    public boolean hasLanguages(Languages languages) {
        return this.getLanguages().contains(languages);
    }

    public ProfessionalProfile addLanguages(Languages languages) {
        if(!hasLanguages(languages)){
            this.getLanguages().add(languages);
        }
        return this;
    }

    public ProfessionalProfile removeLanguages(Languages languages) {
        if (this.hasLanguages(languages))
            this.getLanguages().remove(languages);
        return this;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Studies> getStudies() {
        return studies;
    }

    public void setStudies(List<Studies> studies) {
        this.studies = studies;
    }
}
