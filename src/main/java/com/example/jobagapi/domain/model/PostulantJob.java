package com.example.jobagapi.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "postulantJob")
@IdClass(PostulantJobId.class)
public class PostulantJob{
    @Id
    private Long postulantId;

    @Id
    private Long jobOfferId;

    @NotNull
    private boolean accept;

    @ManyToOne
    @JoinColumn(name = "postulantid",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Postulant postulant;

    @ManyToOne
    @JoinColumn(name = "jobOfferid",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private JobOffer JobOffer;

    public PostulantJob() {
    }

    public PostulantJob(Long postulantId, Long jobOfferId, boolean accept) {
        this.postulantId = postulantId;
        this.jobOfferId = jobOfferId;
        this.accept = accept;
    }

    public Long getPostulantId() {
        return postulantId;
    }

    public PostulantJob setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
        return this;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public PostulantJob setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
        return this;
    }

    public boolean isAccept() {
        return accept;
    }

    public PostulantJob setAccept(boolean accept) {
        this.accept = accept;
        return this;
    }

    public Postulant getPostulant() {
        return postulant;
    }

    public PostulantJob setPostulant(Postulant postulant) {
        this.postulant = postulant;
        return this;
    }

    public com.example.jobagapi.domain.model.JobOffer getJobOffer() {
        return JobOffer;
    }

    public PostulantJob setJobOffer(com.example.jobagapi.domain.model.JobOffer jobOffer) {
        JobOffer = jobOffer;
        return this;
    }
}
