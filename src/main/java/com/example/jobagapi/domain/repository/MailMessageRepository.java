package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.MailMessage;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MailMessageRepository extends JpaRepository<MailMessage, Long> {

    Page<MailMessage> findByPostulantId(Long postulantId, Pageable pageable); //Encontrar por Id
    Page<MailMessage> findByEmployeerId(Long postulantId, Pageable pageable); //Encontrar por Id

    Optional<MailMessage> findByIdAndPostulantId(Long id, Long postulantId);
    Optional<MailMessage> findByIdAndEmployeerId(Long id, Long employeerId);
}