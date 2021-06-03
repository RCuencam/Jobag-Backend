package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.service.ProfessionalProfileService;
import com.example.jobagapi.resource.ProfessionalProfileResource;
import com.example.jobagapi.resource.SaveProfessionalProfileResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")

public class ProfessionalProfileStudiesController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Operation(summary = "Assign Studies to ProfessionalProfile",
            description = "Establishes association between Studies and ProfessionalProfile",
            tags = {"professionalprofile"}
    )
    @PostMapping("/professionalprofile/{professionalprofileId}/studies/{studiesId}")
    public ProfessionalProfileResource assignProfessionalProfileStudy(
            @PathVariable Long professionalprofileId,
            @PathVariable Long studiesId) {
        return convertToResource(professionalprofileService.assignProfessionalProfileStudy(professionalprofileId, studiesId));
    }

    @Operation(summary = "Remove assignment between Studies and ProfessionalProfile",
            description = "Ends association between ProfessionalProfile and Studies",
            tags = {"professionalprofile"}
    )
    @DeleteMapping("/professionalprofile/{professionalprofileId}/studies/{studiesId}")
    public ProfessionalProfileResource unassignProfessionalProfileStudy(
            @PathVariable Long professionalprofileId,
            @PathVariable Long studiesId) {
        return convertToResource(professionalprofileService.unassignProfessionalProfileStudy(professionalprofileId, studiesId));
    }


    @Operation(summary = "List assignment between studies and ProfessionalProfile",
            description = "List association between ProfessionalProfile and studies",
            tags = {"professionalprofile"}
    )

    @GetMapping("/studies/{studiesId}/professionalprofile")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileByStudiesId(
            @PathVariable Long studiesId,
            Pageable pageable) {
        Page<ProfessionalProfile> postsPage = professionalprofileService.getAllProfessionalProfileByStudiesId(studiesId, pageable);
        List<ProfessionalProfileResource> resources = postsPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private ProfessionalProfile convertToEntity(SaveProfessionalProfileResource resource) {
        return mapper.map(resource, ProfessionalProfile.class);
    }

    private ProfessionalProfileResource convertToResource(ProfessionalProfile entity) {
        return mapper.map(entity, ProfessionalProfileResource.class);
    }
}
