package com.example.jobagapi.domain.model;

import javax.persistence.Column;
import java.io.Serializable;

public class PostulantJobId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "postulantid")
    private Long postulantId;

    @Column(name = "jobOfferid")
    private Long jobOfferId;

    public PostulantJobId() {
    }

    public PostulantJobId(Long postulantId, Long jobOfferId) {
        this.postulantId = postulantId;
        this.jobOfferId = jobOfferId;
    }

    public Long getPostulantId() {
        return postulantId;
    }

    public PostulantJobId setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
        return this;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public PostulantJobId setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
        return this;
    }
}
