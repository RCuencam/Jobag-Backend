package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Postulant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant,Long> {
    public Page<Postulant> findById(Long Id, Pageable page);
}
