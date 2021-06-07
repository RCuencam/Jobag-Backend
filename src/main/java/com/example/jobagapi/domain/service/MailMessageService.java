package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.MailMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface MailMessageService {
    //creacion del mensaje
    MailMessage createMailMessage(Long postulantId, Long employeerId, MailMessage mailMessage);
    //Modificacion del mensaje
    MailMessage updateMailMessage(Long postulantId, Long employeerId, Long mailMessageId, MailMessage mailMessageDetails);
    //Eliminacion del mensaje
    ResponseEntity<?> deleteMailMessage(Long postulantId, Long employeerId, Long mailMessageId);
    //Retornar todos los mensaje segun el ID del postulante
    Page<MailMessage> getAllMailMessagebByPostulantId(Long postulantId, Pageable pageable);
    //Retornar todos los mensaje segun el ID del empleador
    Page<MailMessage> getAllMailMessagebByEmployeerId(Long employeerId, Pageable pageable);
    //Retornamos los mensajes segun el id del postulante y empleador
    Page<MailMessage> getAllMailMessagesByPostulantIdAnEmployeerId(Long postulantId, Long employeerId, Pageable pageable);
}