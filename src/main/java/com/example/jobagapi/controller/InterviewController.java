package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.model.PlanPostulant;
import com.example.jobagapi.domain.service.InterviewService;
import com.example.jobagapi.resource.InterviewResource;
import com.example.jobagapi.resource.PlanPostulantResource;
import com.example.jobagapi.resource.SaveInterviewResource;
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
public class InterviewController {

    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/interview/{postulantId}/interview")
    public InterviewResource createInterview(
            @PathVariable Long postulantId,
            @Valid @RequestBody SaveInterviewResource resource) {
        return convertToResource(interviewService.createInterview(postulantId, convertToEntity(resource)));
    }

    @DeleteMapping("/postulant/{postulantId}/interview/{interviewId}")
    public ResponseEntity<?> deleteInterview(
            @PathVariable Long postulantId,
            @PathVariable Long interviewId) {
        return interviewService.deleteInterview(postulantId, interviewId);
    }

    @PutMapping("/postulant/{postulantId}/interview/{interviewId}")
    public InterviewResource updateInterview(
            @PathVariable Long postulantId,
            @PathVariable Long interviewId,
            @Valid @RequestBody SaveInterviewResource resource) {
        return convertToResource(interviewService.updateInterview(postulantId, interviewId, convertToEntity(resource)));
    }

    @GetMapping("/interview/{interviewId}/postulant/{postulantId}")
    public InterviewResource getInterviewByIdAndPostulantId(
            @PathVariable Long postulantId,
            @PathVariable Long interviewId) {
        return convertToResource(interviewService.getInterviewByIdAndPostulantId(interviewId, postulantId));
    }

    @GetMapping("/postulant/{postulantId}/postulants")
    public Page<InterviewResource> getAllInterviewsByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        Page<Interview> interviewPage = interviewService.getAllInterviewsByPostulantId(postulantId, pageable);
        List<InterviewResource> resources = interviewPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private Interview convertToEntity(SaveInterviewResource resource){
        return mapper.map(resource, Interview.class);
    }

    private InterviewResource convertToResource(Interview entity){
        return mapper.map(entity,InterviewResource.class);
    }

}
