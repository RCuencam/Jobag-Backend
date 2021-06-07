package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.*;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.MailMessageRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.MailMessageService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MailMessageServiceImpl implements MailMessageService {
    @Autowired
    private PostulantRepository postulantRepository;
    @Autowired
    private MailMessageRepository mailMessageRepository;
    @Autowired
    private EmployeerRepository employeerRepository;

    @Override
    public MailMessage createMailMessage(Long postulantId, Long employeerId, MailMessage mailMessage) {
        //Comprobamos que exista el postulante
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        //Comprobamos que exista el employeer
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return postulantRepository.findById(postulantId).map(postulant -> {
            mailMessage.setPostulant(postulant);
            employeerRepository.findById(employeerId).map(employeer -> {
                mailMessage.setEmployeer(employeer);
                return  mailMessageRepository.save(mailMessage);
            }).orElseThrow(() -> new ResourceNotFoundException("Employeer", "Id", employeerId));
            return  mailMessageRepository.save(mailMessage);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant", "Id", postulantId));
    }

    @Override
    public MailMessage updateMailMessage(Long postulantId, Long employeerId, Long mailMessageId, MailMessage mailMessageDetails) {
        //Comprobamos que exista el postulante
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
            //Comprobamos que exista el employeer
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return mailMessageRepository.findById(mailMessageId).map(mailMessage -> {
            mailMessage.setMessage(mailMessageDetails.getMessage())
                    .setDocument_Link(mailMessageDetails.getDocument_Link());
            return  mailMessageRepository.save(mailMessage);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant Id" + postulantId + "Employeer Id" + employeerId));
    }

    @Override
    public ResponseEntity<?> deleteMailMessage(Long postulantId, Long employeerId, Long mailMessageId) {
        //Comprobamos que exista el postulante
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        //Comprobamos que exista el employeer
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return mailMessageRepository.findById(mailMessageId).map(mailMessage -> {
            mailMessageRepository.delete(mailMessage);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Mail Message", "Id", mailMessageId));
    }

    @Override
    public Page<MailMessage> getAllMailMessagebByPostulantId(Long postulantId, Pageable pageable) {
        return mailMessageRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public Page<MailMessage> getAllMailMessagebByEmployeerId(Long employeerId, Pageable pageable) {
        return mailMessageRepository.findByEmployeerId(employeerId, pageable);
    }

    @Override
    public Page<MailMessage> getAllMailMessagesByPostulantIdAnEmployeerId(Long postulantId, Long employeerId, Pageable pageable) {
        return mailMessageRepository.findByPostulantIdAndEmployeerId(postulantId,employeerId,pageable);
    }

}