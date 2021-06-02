package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.JobOffer;
import com.example.jobagapi.domain.service.JobOfferService;
import com.example.jobagapi.resource.JobOfferResource;
import com.example.jobagapi.resource.SaveJobOfferResource;
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
public class JobOfferController {
    @Autowired
    private JobOfferService jobOfferService;
    @Autowired
    private ModelMapper mapper;

    //FALTA MODIFICAR
    @GetMapping("/jobOffers")
    public Page<JobOfferResource> getAllJobOffers(
            @PathVariable Long employeerId,
            Pageable pageable) {
        Page<JobOffer> jobOfferPage = jobOfferService.getAllJobOffersByEmployeerId(employeerId, pageable);
        List<JobOfferResource> resources = jobOfferPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/jobOffer/{jobOfferId}/employeer/{employeerId}")
    public JobOfferResource getJobOfferByIdAndEmployeerId(
            @PathVariable Long employeerId,
            @PathVariable Long jobOfferId) {
        return convertToResource(jobOfferService.getJobOfferByIdAndEmployeerId(jobOfferId, employeerId));
    }

    @PostMapping("/jobOffer/{employeerId}/jobOffers")
    public JobOfferResource createJobOffer(
            @PathVariable Long employeerId,
            @Valid @RequestBody SaveJobOfferResource resource) {
        return convertToResource(jobOfferService.createJobOffer(employeerId, convertToEntity(resource)));
    }

    @PutMapping("/employeer/{employeerId}/jobOffer/{jobOfferId}")
    public JobOfferResource updateFarmland(
            @PathVariable Long employeerId,
            @PathVariable Long jobOfferId,
            @Valid @RequestBody SaveJobOfferResource resource) {
        return convertToResource(jobOfferService.updateJobOffer(employeerId, jobOfferId, convertToEntity(resource)));
    }

    @DeleteMapping("/employeer/{employeerId}/jobOffer/{jobOfferId}")
    public ResponseEntity<?> deleteJobOffer(
            @PathVariable Long employeerId,
            @PathVariable Long jobOfferId) {
        return jobOfferService.deleteJobOffer(employeerId, jobOfferId);
    }

    private JobOffer convertToEntity(SaveJobOfferResource resource){
        return mapper.map(resource, JobOffer.class);
    }

    private JobOfferResource convertToResource(JobOffer entity){
        return mapper.map(entity,JobOfferResource.class);
    }
}
