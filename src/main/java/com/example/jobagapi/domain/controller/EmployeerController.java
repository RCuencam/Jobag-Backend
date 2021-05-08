package com.example.jobagapi.domain.controller;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.resource.EmployeerResource;
import com.example.jobagapi.domain.resource.SaveEmployeerResource;
import com.example.jobagapi.domain.service.EmployeerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeerController {
    @Autowired
    private EmployeerService employeerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Get Employeers", description="Get All Employeers", tags={"Employeers"})
    @GetMapping("/employeers")
    public Page<EmployeerResource> getAllEmployeers(Pageable pageable){
        Page<Employeer> employeerPage = employeerService.getAllEmployeers(pageable);
        List<EmployeerResource> resources = employeerPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Post Employeer", description="Post Employeer", tags={"Employeers"})
    @PostMapping("/employeers")
    public EmployeerResource createEmployeer(@Valid @RequestBody SaveEmployeerResource resource) {
        Employeer employeer = convertToEntity(resource);
        return convertToResource(employeerService.createEmployeer(employeer));
    }


    @Operation(summary="Get Employeer By Id", description="Get Employeer", tags={"Employeers"})
    @GetMapping("/employeer/{employeerId}}")
    public EmployeerResource getEmployeerById(@PathVariable Long employeerId) {
        return convertToResource(employeerService.getEmployeerById(employeerId));
    }

    @Operation(summary="Delete Employeer", description="Delete Employeer", tags={"Employeers"})
    @DeleteMapping("/employeer/{employeerId}}")

    public ResponseEntity<?> deleteEmployeer(@PathVariable Long employeerId) {
        return employeerService.deleteEmployeer(employeerId);
    }


    private Employeer convertToEntity(SaveEmployeerResource resource) {
        return mapper.map(resource, Employeer.class);
    }
    private EmployeerResource convertToResource(Employeer entity)
    {
        return mapper.map(entity, EmployeerResource.class);
    }


}
