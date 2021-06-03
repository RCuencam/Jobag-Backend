package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.service.PostulantJobService;
import com.example.jobagapi.resource.PostulantJobResource;
import com.example.jobagapi.resource.SavePostulantJobResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostulantJobController {
    @Autowired
    private PostulantJobService postulantJobService;
    @Autowired
    private ModelMapper mapper;

    private PostulantJob convertToEntity(SavePostulantJobResource resource){
        return mapper.map(resource, PostulantJob.class);
    }

    @PostMapping("/jobOffer/{jobOfferId}/postulants/{postulantId}")
    public Object createPostulantJob(
            @PathVariable Long jobOfferId,
            @PathVariable Long postulantId,
            @Valid @RequestBody SavePostulantJobResource resource) {
        return convertToResource(postulantJobService.createPostulantJob(jobOfferId,postulantId,convertToEntity(resource)));
    }

    private PostulantJobResource convertToResource(PostulantJob entity){
        return mapper.map(entity,PostulantJobResource.class);
    }
}
