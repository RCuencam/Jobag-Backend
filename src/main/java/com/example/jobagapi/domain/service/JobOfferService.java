package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.JobOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface JobOfferService {
    Page<JobOffer> getAllJobOffersByEmployeerId(Long employeerId, Pageable pageable);
    JobOffer getJobOfferByIdAndEmployeerId(Long employeerId, Long jobOfferId);
    JobOffer createJobOffer(Long employeerId, JobOffer jobOffer);
    JobOffer updateJobOffer(Long employeerId, Long jobOfferId, JobOffer jobOfferDetails);
    ResponseEntity<?> deleteJobOffer(Long employeerId, Long jobOfferId);
}
