package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


public interface CompanyService {
    Page<Company> getAllCompanysByEmployeerId(Long employeerId, Pageable pageable);
    Company getCompanyByIdAndEmployeerId(Long employeerId, Long companysId);
    Page<Company> getAllCompanysBySectorId(Long sectorId, Pageable pageable);
    Company getCompanyByIdAndSectorId(Long sectorId, Long companysId);

    Company createCompany(Long employeerId, Company company);
    Company updateCompany(Long employeerId, Long companyId, Company companyDetails);
    ResponseEntity<?> deleteCompany(Long employeerId,  Long companyId);
}
