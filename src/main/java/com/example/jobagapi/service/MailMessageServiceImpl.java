package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.model.ProfessionalProfile;
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

import javax.persistence.Id;

@Service
public class MailMessageServiceImpl implements MailMessageService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private MailMessageRepository mailMessageRepository;

    @Override
    public Page<MailMessage> getAllMailMessageById(Long Id, Pageable pageable) {
        if (postulantRepository.findById(Id) != null)
            return mailMessageRepository.findByPostulantId(Id,pageable);

        if(employeerRepository.findById(Id) != null)
            return mailMessageRepository.findByEmployeerId(Id,pageable);

        throw new ResourceNotFoundException("No found","Id",Id);
    }

    @Override
    public MailMessage getMailMessageByIdAndPostulantId(Long postulantId, Long mailmessageId) {
        return mailMessageRepository.findByIdAndPostulantId(postulantId,mailmessageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + mailmessageId+
                                "and PostulantId" + postulantId));
    }

    @Override
    public MailMessage getMailMessageByIdAndEmployeerId(Long employeerId, Long mailmessageId) {
        return mailMessageRepository.findByIdAndPostulantId(employeerId,mailmessageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + mailmessageId+
                                "and EmployeerId" + employeerId));
    }

    @Override
    public MailMessage createMailMessage(Long Id, MailMessage mailMessage) {
        if (postulantRepository.findById(Id) != null){
            return postulantRepository.findById(Id).map(postulant -> {
                mailMessage.setPostulant(postulant);
                return mailMessageRepository.save(mailMessage);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Postulant", "Id",Id));}

        if(employeerRepository.findById(Id) != null){
            return employeerRepository.findById(Id).map(employeer -> {
                mailMessage.setEmployeer(employeer);
                return mailMessageRepository.save(mailMessage);
            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Employeer", "Id",Id));}

        throw new ResourceNotFoundException("Employeer","Id",Id);
    }

    @Override
    public MailMessage updateMailMessage(Long Identify, Long mailmessageId, MailMessage mailmessageDetails) {
            if(!postulantRepository.existsById(Identify))
                throw new ResourceNotFoundException("Postulant","Id",Identify);

            if(!employeerRepository.existsById(Identify))
                throw new ResourceNotFoundException("Employeer","Id",Identify);

            return mailMessageRepository.findById(mailmessageId).map(mailMessage -> {
                mailMessage.setMessage(mailmessageDetails.getMessage());
                return mailMessageRepository.save(mailMessage);

            }).orElseThrow(() -> new ResourceNotFoundException(
                    "MailMessage","Id",mailmessageId));
    }

    @Override
    public ResponseEntity<?> deleteMailMessage(Long Id, Long mailmessageId) {
        if (postulantRepository.findById(Id) != null){
            if (!mailMessageRepository.existsById(mailmessageId))
                throw new ResourceNotFoundException("Postulant", "Id", Id);

            return mailMessageRepository.findById(mailmessageId).map(mailMessage -> {
                mailMessageRepository.delete(mailMessage);
                return ResponseEntity.ok().build();


            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Company", "Id", mailmessageId));
        }
        if(employeerRepository.findById(Id) != null){
            if (!mailMessageRepository.existsById(mailmessageId))
                throw new ResourceNotFoundException("Employeer", "Id", Id);

            return mailMessageRepository.findById(mailmessageId).map(mailMessage -> {
                mailMessageRepository.delete(mailMessage);
                return ResponseEntity.ok().build();


            }).orElseThrow(() -> new ResourceNotFoundException(
                    "Company", "Id", mailmessageId));
        }
        else
            return null;
    }
}