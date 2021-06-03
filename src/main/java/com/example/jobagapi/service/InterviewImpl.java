package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.repository.InterviewRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.InterviewService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InterviewImpl  implements InterviewService {
    @Autowired
    private PostulantRepository postulantRepository;
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Page<Interview> getAllInterviewsByPostulantId(Long postulantId, Pageable pageable) {
        return interviewRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public Interview getInterviewByIdAndPostulantId(Long postulantId, Long interviewId) {
        return interviewRepository.findByIdAndPostulantId(postulantId,interviewId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Interview not found with id" + interviewId +
                                "and Postulant" + postulantId));
    }

    @Override
    public Interview createInterview(Long postulantId, Interview interview) {
        return postulantRepository.findById(postulantId).map(postulant -> {
            interview.setPostulant(postulant);
            return interviewRepository.save(interview);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant","Id",postulantId));
    }

    @Override
    public Interview updateInterview(Long postulantId, Long interviewId, Interview interviewDetails) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        return interviewRepository.findById(interviewId).map(interview -> {
            interview.setDate_Interview(interviewDetails.getDate_Interview())
                    .setFinal_date_Interview(interviewDetails.getFinal_date_Interview())
                    .setLink_Interview(interviewDetails.getLink_Interview());
            return interviewRepository.save(interview);
        }).orElseThrow(() -> new ResourceNotFoundException("Interview","Id",interviewId));
    }

    @Override
    public ResponseEntity<?> deleteInterview(Long postulantId, Long interviewId) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        return interviewRepository.findById(interviewId).map(interview -> {
            interviewRepository.delete(interview);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Interview","Id",interviewId));
    }
}
