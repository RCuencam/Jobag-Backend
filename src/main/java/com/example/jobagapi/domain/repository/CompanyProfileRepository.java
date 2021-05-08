package com.example.jobagapi.domain.repository;

import com.example.jobagapi.domain.model.CompanyProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile,Long> {
    Page<CompanyProfile> findByEmployeerId(Long employeerId, Pageable pageable);
    Optional<CompanyProfile> findByIdAndEmployeerId(Long id, Long employeerId);
}
