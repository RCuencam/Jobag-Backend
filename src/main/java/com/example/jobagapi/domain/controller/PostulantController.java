package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.service.PostulantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostulantController {
    @Autowired
    private PostulantService postulantService;
    @GetMapping("/postulants")
    public Page<Postulant> getAllPostulants(Pageable pageable){
        Page<Postulant> postulantPage = postulantService.getAllPostulants(pageable);
        return postulantPage;
    }
}
