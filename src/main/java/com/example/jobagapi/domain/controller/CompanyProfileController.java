package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.CompanyProfile;
import com.example.jobagapi.domain.resource.CompanyProfileResource;
import com.example.jobagapi.domain.resource.SaveCompanyProfileResource;
import com.example.jobagapi.domain.service.CompanyProfileService;
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
public class CompanyProfileController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CompanyProfileService companyProfileService;

    @Operation(summary="Get Company Profile by Employeer Id", description="Get Company Profile by Employeer Id", tags={"Company Profile"})
    @GetMapping("/employeers/{employeerId}/company_profile")
    public Page<CompanyProfileResource> getAllCompanyProfileByEmployeerId(@PathVariable Long employeerId, Pageable pageable) {
        Page<CompanyProfile> commentPage = companyProfileService.getAllCompanyProfileByEmployeerId(employeerId, pageable);
        List<CompanyProfileResource> resources = commentPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Create Company Profile by EmployeerId", description="Create Company Profile by EmployeerId", tags={"Company Profile"})
    @PostMapping("/{employeerId}/company_profile")
    public CompanyProfileResource  createCompanyProfileByEmployeerId(@PathVariable Long employeerId,@Valid @RequestBody SaveCompanyProfileResource resource) {
        return convertToResource(companyProfileService.createCompanyProfile(employeerId,
                convertToEntity(resource)));
    }


    @Operation(summary="Delete Company Profile by Id", description="Delete Company Profile by Id", tags={"Company Profile"})
    @DeleteMapping("/{employeerId}/{companyProfileId}")
    public ResponseEntity<?> deleteCompanyProfile(@PathVariable Long employeerId,@PathVariable Long companyProfileId) {
        return companyProfileService.deleteCompanyProfile(employeerId,companyProfileId);
    }

    private CompanyProfile convertToEntity(SaveCompanyProfileResource resource) {
        return mapper.map(resource, CompanyProfile.class);
    }

    private CompanyProfileResource convertToResource(CompanyProfile companyProfile) {
        return mapper.map(companyProfile, CompanyProfileResource.class);
    }

}
