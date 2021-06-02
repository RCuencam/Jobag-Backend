package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.JobOffer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.JobOfferRepository;
import com.example.jobagapi.domain.service.JobOfferService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JobOfferServiceImpl implements JobOfferService {
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private EmployeerRepository employeerRepository;

    @Override
    public Page<JobOffer> getAllJobOffersByEmployeerId(Long employeerId, Pageable pageable) {
        return jobOfferRepository.findAll(pageable);
    }

    @Override
    public JobOffer getJobOfferByIdAndEmployeerId(Long employeerId, Long jobOfferId) {
        return jobOfferRepository.findByIdAndEmployeerId(employeerId,jobOfferId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Job Offer not found with id" + jobOfferId +
                                "and EmployeerId" + employeerId));
    }

    @Override
    public JobOffer createJobOffer(Long employeerId, JobOffer jobOffer) {
        return employeerRepository.findById(employeerId).map(employeer -> {
            jobOffer.setEmployeer(employeer);
            return jobOfferRepository.save(jobOffer);
        }).orElseThrow(() -> new ResourceNotFoundException("Employeer","Id",employeerId));
    }

    @Override
    public JobOffer updateJobOffer(Long employeerId, Long jobOfferId, JobOffer jobOfferDetails) {
        if(!employeerRepository.existsById(employeerId))
            throw  new ResourceNotFoundException("Employeer","Id",employeerId);
        return jobOfferRepository.findById(jobOfferId).map(jobOffer -> {
            jobOffer.setDescription(jobOfferDetails.getDescription())
                    .setDirection(jobOfferDetails.getDirection())
                    .setSalary(jobOfferDetails.getSalary());
            return jobOfferRepository.save(jobOffer);
        }).orElseThrow(() -> new ResourceNotFoundException("Job Offer","Id",jobOfferId));
    }

    @Override
    public ResponseEntity<?> deleteJobOffer(Long employeerId, Long jobOfferId) {
        if(!employeerRepository.existsById(employeerId))
            throw  new ResourceNotFoundException("Employeer","Id",employeerId);
        return jobOfferRepository.findById(jobOfferId).map(jobOffer -> {
            jobOfferRepository.delete(jobOffer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Job Offer","Id",jobOfferId));
    }
}
