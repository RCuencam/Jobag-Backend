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

public class ProfessionalProfileSkillsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Operation(summary = "Assign Skills to ProfessionalProfile",
            description = "Establishes association between Skills and ProfessionalProfile",
            tags = {"professionalprofile"}
    )
    @PostMapping("/professionalprofile/{professionalprofileId}/skills/{skillsId}")
    public ProfessionalProfileResource assignProfessionalProfileSkill(
            @PathVariable Long professionalprofileId,
            @PathVariable Long skillsId) {
        return convertToResource(professionalprofileService.assignProfessionalProfileSkill(professionalprofileId, skillsId));
    }

    @Operation(summary = "Remove assignment between Skills and ProfessionalProfile",
            description = "Ends association between ProfessionalProfile and Skills",
            tags = {"professionalprofile"}
    )
    @DeleteMapping("/professionalprofile/{professionalprofileId}/skills/{skillsId}")
    public ProfessionalProfileResource unassignProfessionalProfileSkill(
            @PathVariable Long professionalprofileId,
            @PathVariable Long skillsId) {
        return convertToResource(professionalprofileService.unassignProfessionalProfileSkill(professionalprofileId, skillsId));
    }


    @Operation(summary = "List assignment between skills and ProfessionalProfile",
            description = "List association between ProfessionalProfile and skills",
            tags = {"professionalprofile"}
    )

    @GetMapping("/skills/{skillsId}/professionalprofile")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileBySkillsId(
            @PathVariable Long skillsId,
            Pageable pageable) {
        Page<ProfessionalProfile> postsPage = professionalprofileService.getAllProfessionalProfileBySkillId(skillsId, pageable);
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