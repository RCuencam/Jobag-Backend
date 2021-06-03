package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.PostulantJob;

public interface PostulantJobService {
    //Primero creamos con una sola entidad -- es JobOffer
    PostulantJob createPostulantJob(Long jobOfferId, Long postulantId, PostulantJob postulantJob);
}
