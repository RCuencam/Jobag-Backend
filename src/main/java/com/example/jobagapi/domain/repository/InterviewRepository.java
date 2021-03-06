package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Interview;
import io.cucumber.java.sl.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    public Page<Interview> findById(Long Id, Pageable pageable);
    Page<Interview> findByPostulantId(Long PostulantId, Pageable pageable);
    Page<Interview> findByJobOfferId(Long JobOfferId, Pageable pageable);
    public Page<Interview> findByPostulantIdAndJobOfferId(Long PostulantId, Long JobOfferId, Pageable pageable);
    Boolean existsByPostulantId(Long postulantId);
    Boolean existsByJobOfferId(Long jobOfferId);
}
