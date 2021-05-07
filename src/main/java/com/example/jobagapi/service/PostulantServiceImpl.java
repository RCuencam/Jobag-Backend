package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PostulantService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostulantServiceImpl implements PostulantService {

    @Autowired
    private PostulantRepository postulantRepository;


    @Override
    public Page<Postulant> getAllPostulants(Pageable pageable) {
        return postulantRepository.findAll(pageable);
    }

    @Override
    public Postulant getPostulantById(Long postulantId) {
        return postulantRepository.findById(postulantId)
                .orElseThrow(()->new ResourceNotFoundException("Postulant", "Id",postulantId));

    }

    @Override
    public Postulant createPostulant(Postulant postulant) {
        return postulantRepository.save(postulant);
    }

    @Override
    public ResponseEntity<?> deleteEPostulant(Long postulantId) {
        Postulant postulant = postulantRepository.findById(postulantId)
                .orElseThrow(()->new ResourceNotFoundException("Postulant", "Id",postulantId));
        postulantRepository.delete(postulant);
        return ResponseEntity.ok().build();
    }
}
