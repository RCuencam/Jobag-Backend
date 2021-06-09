package com.example.jobagapi.controller;


import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.service.ProfessionalProfileService;
import com.example.jobagapi.resource.ProfessionalProfileResource;
import com.example.jobagapi.resource.SaveProfessionalProfileResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class ProfessionalProfileController {
    @Autowired
    private ProfessionalProfileService professionalprofileService;

    @Autowired
    private ModelMapper mapper;


    @Operation(summary="Get profiles", description="Get all profiles", tags={"profiles"})

    @GetMapping("/postulants/{postulantId}/profiles")
    public Page<ProfessionalProfileResource> getAllProfessionalProfileByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        Page<ProfessionalProfile> professionalprofilePage = professionalprofileService.getAllProfessionalProfileByPostulantId(postulantId, pageable);
        List<ProfessionalProfileResource> resources = professionalprofilePage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @Operation(summary="Get profiles", description="Get profiles by postulantId", tags={"profiles"})

    @GetMapping("/postulants/{postulantId}/profiles/{profileId}")
    public ProfessionalProfileResource getProfessionalProfileByIdAndPostulantId(@PathVariable Long postulantId, @PathVariable Long professionalprofileId) {
        return convertToResource(professionalprofileService.getProfessionalProfileByIdAndPostulantId(postulantId, professionalprofileId));
    }



    @Operation(summary="Post profiles", description="Create profiles", tags={"profiles"})

    @PostMapping("/postulants/{postulantId}/profiles")
    public ProfessionalProfileResource createProfessionalProfile(
            @PathVariable Long postulantId,@Valid @RequestBody SaveProfessionalProfileResource resource) {
        return convertToResource(professionalprofileService.createProfessionalProfile(postulantId, convertToEntity(resource)));
    }


    @Operation(summary="Put profiles", description="Update profiles", tags={"profiles"})

    @PutMapping("/postulants/{postulantId}/profiles/{profileId}")
    public ProfessionalProfileResource updateProfessionalProfile(
            @PathVariable Long postulantId,
            @PathVariable Long professionalprofileId,
            @Valid @RequestBody SaveProfessionalProfileResource resource) {
        return convertToResource(professionalprofileService.updateProfessionalProfile(postulantId, professionalprofileId, convertToEntity(resource)));
    }


    @Operation(summary="Delete profiles", description="Delete profiles", tags={"profiles"})

    @DeleteMapping("/postulants/{postulantId}/profiles/{profileId}")
    public ResponseEntity<?> deleteProfessionalProfile(
            @PathVariable Long postulantId,
            @PathVariable Long professionalprofileId) {
        return professionalprofileService.deleteProfessionalProfile(postulantId, professionalprofileId);
    }


    private ProfessionalProfile convertToEntity(SaveProfessionalProfileResource resource) {
        return mapper.map(resource, ProfessionalProfile.class);
    }

    private ProfessionalProfileResource convertToResource(ProfessionalProfile entity) {
        return mapper.map(entity, ProfessionalProfileResource.class);
    }

}
