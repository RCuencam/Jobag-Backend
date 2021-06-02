package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.PlanPostulant;
import com.example.jobagapi.domain.service.PlanPostulantService;
import com.example.jobagapi.resource.PlanPostulantResource;
import com.example.jobagapi.resource.SavePlanPostulantResource;
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
public class PlanPostulantController {

    @Autowired
    private PlanPostulantService planPostulantService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/postulants/{postulantId}/planpostulants")
    public Page<PlanPostulantResource> getAllPlanPostulantsByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        Page<PlanPostulant> planpostulantPage = planPostulantService.getAllPlanPostulantsByPostulantId(postulantId, pageable);
        List<PlanPostulantResource> resources = planpostulantPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/postulants/{postulantId}/planpostulants/{planpostulantId}")
    public PlanPostulantResource getPlanemployeerByIdAndEmployeerId(@PathVariable Long postulantId, @PathVariable Long planpostulantId) {
        return convertToResource(planPostulantService.getPlanPostulantByIdAndPostulantId(planpostulantId, postulantId));
    }

    @PostMapping("/postulants/{postulantId}/planpostulants")
    public PlanPostulantResource createPlanPostulant(
            @PathVariable Long postulantId,@Valid @RequestBody SavePlanPostulantResource resource) {
        return convertToResource(planPostulantService.createPlanPostulant(postulantId, convertToEntity(resource)));
    }

    @PutMapping("/postulants/{postulantId}/planpostulants/{planpostulantId}")
    public PlanPostulantResource updatePlanemployeer(
            @PathVariable Long postulantId,
            @PathVariable Long planpostulantId,
            @Valid @RequestBody SavePlanPostulantResource resource) {
        return convertToResource(planPostulantService.updatePlanPostulant(postulantId, planpostulantId, convertToEntity(resource)));
    }

    @DeleteMapping("/postulants/{postulantId}/planpostulants/{planpostulantId}")
    public ResponseEntity<?> deletePlanemployeer(
            @PathVariable Long postulantId,
            @PathVariable Long planpostulantId) {
        return planPostulantService.deletePlanPostulant(postulantId, planpostulantId);
    }

    private PlanPostulant convertToEntity(SavePlanPostulantResource resource) {
        return mapper.map(resource, PlanPostulant.class);
    }

    private PlanPostulantResource convertToResource(PlanPostulant entity) {
        return mapper.map(entity, PlanPostulantResource.class);
    }
}
