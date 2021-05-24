package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.Languages;
import com.example.jobagapi.domain.model.Sector;
import com.example.jobagapi.resource.LanguagesResource;
import com.example.jobagapi.resource.SaveLanguaguesResource;
import com.example.jobagapi.domain.service.LanguagesService;
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
public class LanguagesController {
    @Autowired
    private LanguagesService languagesService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Update Languages", description="Update Languages", tags={"Languages"})
    @PutMapping("/languages/{languagesId}")
    public LanguagesResource updateLanguages(@PathVariable Long languagesId, @Valid @RequestBody SaveLanguaguesResource resource){
        Languages languages = convertToEntity(resource);
        return convertToResource(languagesService.updateLanguages(languagesId,languages));
    }

    @Operation(summary = "Get Languages", description = "Get All Languages", tags = {"Languages"})
    @GetMapping("/languages")
    public Page<LanguagesResource> getAllLanguages(Pageable pageable){
        Page<Languages> languagesPage = languagesService.getAllLanguages(pageable);
        List<LanguagesResource> resources = languagesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }
    @Operation(summary = "Post Languages", description = "Post Languages", tags = {"Languages"})
    @PostMapping("/languages")
    public LanguagesResource createLanguages(@Valid @RequestBody SaveLanguaguesResource resource){
        Languages languages = convertToEntity(resource);
        return  convertToResource(languagesService.createLanguages(languages));
    }

    @Operation(summary = "Get Languages by Id", description = "Get Languages by Id", tags = {"Languages"})
    @GetMapping("/languages/{languagesId}")
    public LanguagesResource getLanguaesById(@PathVariable Long languagesId){
        return convertToResource(languagesService.getLanguagesById(languagesId));
    }
    @Operation(summary = "Delete Language", description = "Delete Language", tags = {"Languages"})
    @DeleteMapping("/languages/{languagesId}")
    public ResponseEntity<?> deleteLanguage(@PathVariable Long languagesId) {
        return languagesService.deleteLanguages(languagesId);
    }

    private Languages convertToEntity(SaveLanguaguesResource resource){
        return mapper.map(resource, Languages.class);
    }

    private LanguagesResource convertToResource(Languages entity){
        return mapper.map(entity, LanguagesResource.class);
    }
}
