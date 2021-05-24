package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Languages;
import com.example.jobagapi.domain.model.Sector;
import com.example.jobagapi.domain.model.Studies;
import com.example.jobagapi.domain.service.StudiesService;
import com.example.jobagapi.resource.*;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StudiesController {
    @Autowired
    private StudiesService studiesService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Update Studies", description="Update Studies", tags={"Studies"})
    @PutMapping("/studies/{studiesId}")
    public StudiesResource updateStudies(@PathVariable Long studiesId, @Valid @RequestBody SaveStudiesResource resource){
        Studies studies = convertToEntity(resource);
        return convertToResource(studiesService.updateStudies(studiesId,studies));
    }

    @Operation(summary = "Get Studies", description = "Get All Studies", tags = {"Studies"})
    @GetMapping("/studies")
    public Page<StudiesResource> getAllStudies(Pageable pageable){
        Page<Studies> studiesPage = studiesService.getAllStudies(pageable);
        List<StudiesResource> resources = studiesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary = "Post Studies", description = "Post Studies", tags = {"Studies"})
    @PostMapping("/studies")
    public  StudiesResource createStudies(@Valid @RequestBody SaveStudiesResource resource){
        Studies studies = convertToEntity(resource);
        return convertToResource(studiesService.createStudies(studies));
    }

    @Operation(summary = "Get Studies by Id", description = "Get Studies by Id", tags = {"Studies"})
    @GetMapping("/studies/{studiesId}")
    public StudiesResource getStudiesById(@PathVariable Long studiesId){
        return convertToResource(studiesService.getStudiesById(studiesId));
    }
    @Operation(summary = "Delete Studies", description = "Delete Studies", tags = {"Studies"})
    @DeleteMapping("/studies/{studiesId}")
    public ResponseEntity<?> deleteStudies(@PathVariable Long studiesId) {
        return studiesService.deleteStudies(studiesId);
    }

    private Studies convertToEntity(SaveStudiesResource resource){
        return mapper.map(resource, Studies.class);
    }

    private StudiesResource convertToResource(Studies entity){
        return mapper.map(entity, StudiesResource.class);
    }

}
