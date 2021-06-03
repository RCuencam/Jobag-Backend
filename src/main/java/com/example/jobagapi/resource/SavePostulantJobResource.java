package com.example.jobagapi.resource;

public class SavePostulantJobResource extends SaveJobOfferResource {
    private boolean accept;

    public boolean isAccept() {
        return accept;
    }

    public SavePostulantJobResource setAccept(boolean accept) {
        this.accept = accept;
        return this;
    }
}
