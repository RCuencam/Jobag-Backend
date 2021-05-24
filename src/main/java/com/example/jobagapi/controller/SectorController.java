package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Sector;
import com.example.jobagapi.domain.service.SectorService;
import com.example.jobagapi.resource.SaveSectorResource;
import com.example.jobagapi.resource.SectorResource;
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
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Get Sectors", description="Get All Sectors", tags={"Sectors"})
    @GetMapping("/sectors")
    public Page<SectorResource> getAllSectors(Pageable pageable){
        Page<Sector> sectorPage = sectorService.getAllSectors(pageable);
        List<SectorResource> resources = sectorPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Post Sectors", description="Post Sectors", tags={"Sectors"})
    @PostMapping("/sectors")
    public SectorResource createSector(@Valid @RequestBody SaveSectorResource resource) {
        Sector sector = convertToEntity(resource);
        return convertToResource(sectorService.createSector(sector));
    }

    @Operation(summary="Update Sector", description="Update Sector", tags={"Sectors"})
    @PutMapping("/sector/{sectorId}")
    public SectorResource updateSector(@PathVariable Long sectorId, @Valid @RequestBody SaveSectorResource resource){
        Sector sector = convertToEntity(resource);
        return convertToResource(sectorService.updateSector(sectorId,sector));
    }

    @Operation(summary="Get SectorsById", description="Get SectorsById", tags={"Sectors"})
    @GetMapping("/sector/{id}")
    public SectorResource getSectorById(@PathVariable(name = "id") Long sectorId) {
        return convertToResource(sectorService.getSectorById(sectorId));
    }

    @Operation(summary="Delete Sector By Id", description="DeleteSectorById", tags={"Sectors"})
    @DeleteMapping("/sector/{sectorId}}")
    public ResponseEntity<?> deleteSector(@PathVariable Long sectorId) {
        return sectorService.deleteSector(sectorId);
    }

    private Sector convertToEntity(SaveSectorResource resource) {
        return mapper.map(resource, Sector.class);
    }
    private SectorResource convertToResource(Sector entity)
    {
        return mapper.map(entity, SectorResource.class);
    }

}
