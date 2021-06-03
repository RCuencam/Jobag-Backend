package com.example.jobagapi.domain.repository;


import com.example.jobagapi.domain.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Page<Company> findByEmployeerId(Long employeerId, Pageable pageable); //Encontrar por Id

    public Optional<Company> findByIdAndEmployeerId(Long id, Long employeerId);

    Page<Company> findBySectorId(Long sectorId, Pageable pageable); //Encontrar por Id

    public Optional<Company> findByIdAndSectorId(Long id, Long sectorId);

}
