package com.example.jobagapi.resource;

public class PostulantJobResource {
    private Long postulantId;
    private Long jobOfferId;
    private boolean accept;

    public Long getPostulantId() {
        return postulantId;
    }

    public PostulantJobResource setPostulantId(Long postulantId) {
        this.postulantId = postulantId;
        return this;
    }

    public Long getJobOfferId() {
        return jobOfferId;
    }

    public PostulantJobResource setJobOfferId(Long jobOfferId) {
        this.jobOfferId = jobOfferId;
        return this;
    }

    public boolean isAccept() {
        return accept;
    }

    public PostulantJobResource setAccept(boolean accept) {
        this.accept = accept;
        return this;
    }
}
