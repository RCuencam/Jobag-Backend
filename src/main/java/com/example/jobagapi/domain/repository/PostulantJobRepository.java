package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.PlanPostulant;
import com.example.jobagapi.domain.model.PostulantJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulantJobRepository extends JpaRepository<PostulantJob, Long> {
    public Optional<PostulantJob> findByPostulantIdAndJobOfferId(Long jobofferId, Long postulantId);
}
