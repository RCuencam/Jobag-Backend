package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.service.CompanyService;
import com.example.jobagapi.resource.CompanyResource;
import com.example.jobagapi.resource.SaveCompanyResource;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/employeers/{employeerId}/companys")
    public Page<CompanyResource> getAllCompanysByEmployeerId(@PathVariable Long employeerId, Pageable pageable) {
        Page<Company> companyPage = companyService.getAllCompanysByEmployeerId(employeerId, pageable);
        List<CompanyResource> resources = companyPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    @GetMapping("/employeers/{employeerId}/companys/{companyId}")
    public CompanyResource getCompanyByIdAndEmployeerId(@PathVariable Long employeerId, @PathVariable Long companyId) {
        return convertToResource(companyService.getCompanyByIdAndEmployeerId(employeerId, companyId));
    }


    @PostMapping("/employeers/{employeerId}/companys")
    public CompanyResource createCompany(
            @PathVariable Long employeerId,@Valid @RequestBody SaveCompanyResource resource) {
        return convertToResource(companyService.createCompany(employeerId, convertToEntity(resource)));
    }

    @PutMapping("/employeers/{employeerId}/companys/{companyId}")
    public CompanyResource updateCompany(
            @PathVariable Long employeerId,
            @PathVariable Long companyId,
            @Valid @RequestBody SaveCompanyResource resource) {
        return convertToResource(companyService.updateCompany(employeerId, companyId, convertToEntity(resource)));
    }

    @DeleteMapping("/employeers/{employeerId}/companys/{companyId}")
    public ResponseEntity<?> deleteCompany(
            @PathVariable Long employeerId,
            @PathVariable Long companyId) {
        return companyService.deleteCompany(employeerId, companyId);
    }


    private Company convertToEntity(SaveCompanyResource resource) {
        return mapper.map(resource, Company.class);
    }

    private CompanyResource convertToResource(Company entity) {
        return mapper.map(entity, CompanyResource.class);
    }
}