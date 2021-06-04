package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import com.example.jobagapi.domain.service.MailMessageService;
import com.example.jobagapi.resource.MailMessageResource;
import com.example.jobagapi.resource.ProfessionalProfileResource;
import com.example.jobagapi.resource.SaveMailMessageResource;
import com.example.jobagapi.resource.SaveProfessionalProfileResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MailMessageController {

    @Autowired
    private MailMessageService mailmessageService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/postulants/{postulantId}/mailmessages")
    public Page<MailMessageResource> getAllMailMessageById(@PathVariable Long Id, Pageable pageable) {
        Page<MailMessage> mailMessagePage = mailmessageService.getAllMailMessageById(Id, pageable);
        List<MailMessageResource> resources = mailMessagePage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    /*@GetMapping("/postulants/{postulantId}/mailmessages/{mailmessageId}")
    public MailMessageResource getMailMessageByIdAndPostulantId(@PathVariable  Long postulantId,@PathVariable Long mailmessageId){

    }*/

    private MailMessage convertToEntity(SaveMailMessageResource resource) {
        return mapper.map(resource, MailMessage.class);
    }

    private MailMessageResource convertToResource(MailMessage entity) {
        return mapper.map(entity, MailMessageResource.class);
    }

}