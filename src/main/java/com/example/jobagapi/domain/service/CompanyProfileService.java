package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.CompanyProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CompanyProfileService {
    Page<CompanyProfile> getAllCompanyProfileByEmployeerId(Long employeerId, Pageable pageable);
    CompanyProfile getCompanyProfileByIdAndEmployeerId(Long employeerId, Long companyProfileId);
    CompanyProfile createCompanyProfile(Long employeerId, CompanyProfile companyProfile);
    CompanyProfile udpdateCompanyProfile(Long employeerId, Long companyProfileId, CompanyProfile companyProfileDetails);
    ResponseEntity<?> deleteCompanyProfile(Long employeerId, Long companyProfileId);
}
