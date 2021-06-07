package com.example.jobagapi.controller;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.service.MailMessageService;
import com.example.jobagapi.resource.*;
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
public class MailMessageController {
    @Autowired
    private MailMessageService mailmessageService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Create Mail Message", description="Create Mail Message", tags={"mail_messages"})
    @PostMapping("/postulants/{postulantId}/employeers/{employeerId}/mailmessages")
    public MailMessageResource createMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            @Valid @RequestBody SaveMailMessageResource resource) {
        return convertToResource(mailmessageService.createMailMessage(postulantId,employeerId,convertToEntity(resource)));
    }

    @Operation(summary="Get all mail message by postulant ID", description="Get all mail message by postulant ID", tags={"mail_messages"})
    @GetMapping("/postulants/{postulantId}/mailmessages")
    public Page<MailMessageResource> getMaillMessageByPostulantId(
            @PathVariable Long postulantId,
            Pageable pageable) {
        Page<MailMessage> mailMessagePage = mailmessageService.getAllMailMessagebByPostulantId(postulantId, pageable);
        List<MailMessageResource> resources = mailMessagePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get all mail message by employeer ID", description="Get all mail message by employeer ID", tags={"mail_messages"})
    @GetMapping("/employeers/{employeerId}/mailmessages")
    public Page<MailMessageResource> getMaillMessageByEmployeerId(
            @PathVariable Long employeerId,
            Pageable pageable) {
        Page<MailMessage> mailMessagePage = mailmessageService.getAllMailMessagebByEmployeerId(employeerId, pageable);
        List<MailMessageResource> resources = mailMessagePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary="Get all mail message by postulant Id and employeer Id", description="Get all mail message by postulant Id and employeer Id", tags={"mail_messages"})
    @GetMapping("/postulants/{postulantId}/employeers/{employeerId}/mailmessages")
    public Page<MailMessageResource> getAllMailMessagesByPostulantIdAnEmployeerId(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            Pageable pageable) {
        Page<MailMessage> mailMessagePage = mailmessageService.getAllMailMessagesByPostulantIdAnEmployeerId(postulantId, employeerId, pageable);
        List<MailMessageResource> resources = mailMessagePage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable, resources.size());
    }

    @Operation(summary="Delete mail messages by postulant ID and employeer ID", description="Delete mail messages by postulant ID and employeer ID", tags={"mail_messages"})
    @DeleteMapping("/postulants/{postulantId}/employeers/{employeerId}/mailmessages/{mailMessageId}")
    public ResponseEntity<?> deleteMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            @PathVariable Long mailMessageId) {
        return mailmessageService.deleteMailMessage(postulantId, employeerId, mailMessageId);
    }

    @Operation(summary="Put Mail Messages", description="Update Put Mail Messages by Postulant Id and Employeer Id", tags={"mail_messages"})
    @PutMapping("/postulants/{postulantId}/employeers/{employeerId}/mailmessages/{mailMessageId}")
    public MailMessageResource updateMailMessage(
            @PathVariable Long postulantId,
            @PathVariable Long employeerId,
            @PathVariable Long mailMessageId,
            @Valid @RequestBody SaveMailMessageResource resource) {
        return convertToResource(mailmessageService.updateMailMessage(postulantId, employeerId,mailMessageId,convertToEntity(resource)));
    }
    private MailMessage convertToEntity(SaveMailMessageResource resource) {
        return mapper.map(resource, MailMessage.class);
    }

    private MailMessageResource convertToResource(MailMessage entity) {
        return mapper.map(entity, MailMessageResource.class);
    }

}