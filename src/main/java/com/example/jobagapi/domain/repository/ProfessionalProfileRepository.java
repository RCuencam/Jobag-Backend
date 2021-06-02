package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.ProfessionalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalProfileRepository extends JpaRepository<ProfessionalProfile,Long> {
    Page<ProfessionalProfile> findByPostulantId(Long postulantId, Pageable pageable); //Encontrar por Id

    Optional<ProfessionalProfile> findByIdAndPostulantId(Long id, Long postulantId);
}
