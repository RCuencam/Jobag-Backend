package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Postulant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PostulantService {
    Page<Postulant> getAllPostulants(Pageable pageable);
    Postulant getPostulantById(Long postulantId);
    Postulant createPostulant(Postulant postulant);

    ResponseEntity<?> deletePostulant(Long postulantId);
}
