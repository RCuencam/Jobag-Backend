package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Interview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface InterviewService {
    Page<Interview> getAllInterviewsByPostulantId(Long postulantId, Pageable pageable);
    Interview getInterviewByIdAndPostulantId(Long postulantId, Long interviewId);
    Interview createInterview(Long postulantId, Interview interview);
    Interview updateInterview(Long postulantId, Long interviewId, Interview interviewDetails);
    ResponseEntity<?> deleteInterview(Long postulantId, Long interviewId);
}
