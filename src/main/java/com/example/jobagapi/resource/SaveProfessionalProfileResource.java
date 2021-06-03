package com.example.jobagapi.resource;

import com.example.jobagapi.domain.model.AuditModel;

public class SaveProfessionalProfileResource {

    String ocupation;
    String video;
    String description;

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

}
