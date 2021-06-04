package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface MailMessageService {

    Page<MailMessage> getAllMailMessageById(Long Id, Pageable pageable);
    MailMessage getMailMessageByIdAndPostulantId(Long postulantId, Long mailmessageId);

    MailMessage getMailMessageByIdAndEmployeerId(Long employeerId, Long mailmessageId);

    MailMessage createMailMessage(Long Id, MailMessage mailMessage);
    MailMessage updateMailMessage(Long Identify, Long mailmessageId, MailMessage mailmessageDetails);
    ResponseEntity<?> deleteMailMessage(Long Id, Long mailmessageId);

}