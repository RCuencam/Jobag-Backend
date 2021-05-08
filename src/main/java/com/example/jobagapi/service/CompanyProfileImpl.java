package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.CompanyProfile;
import com.example.jobagapi.domain.repository.CompanyProfileRepository;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.service.CompanyProfileService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileImpl implements CompanyProfileService {
    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private CompanyProfileRepository companyProfileRepository;

    @Override
    public Page<CompanyProfile> getAllCompanyProfileByEmployeerId(Long employeerId, Pageable pageable) {
        return companyProfileRepository.findByEmployeerId(employeerId,pageable);
    }

    @Override
    public CompanyProfile getCompanyProfileByIdAndEmployeerId(Long employeerId, Long companyProfileId) {
        return companyProfileRepository.findByIdAndEmployeerId(companyProfileId, employeerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CompanyProfile not found with Id" + companyProfileId +
                        " and EmployeerId " + employeerId));
    }

    @Override
    public CompanyProfile createCompanyProfile(Long employeerId, CompanyProfile companyProfile) {
        return employeerRepository.findById(employeerId).map(employeer -> {
            companyProfile.setEmployeer(employeer);
            return companyProfileRepository.save(companyProfile);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Employeer", "Id", employeerId));
    }

    @Override
    public CompanyProfile udpdateCompanyProfile(Long employeerId, Long companyProfileId, CompanyProfile companyProfileDetails) {
        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyProfileRepository.findById(companyProfileId).map(companyProfile -> {
            companyProfile.setDisctrict(companyProfileDetails.getDisctrict());
            return  companyProfileRepository.save(companyProfile);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "CompanyProfile","Id",companyProfileId));
    }

    @Override
    public ResponseEntity<?> deleteCompanyProfile(Long employeerId, Long companyProfileId) {
        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyProfileRepository.findById(companyProfileId).map(companyProfile -> {
            companyProfileRepository.delete(companyProfile);
            return  ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "CompanyProfile","Id",companyProfileId));
    }
}
