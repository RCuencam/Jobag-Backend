package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Studies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StudiesService {
    Page<Studies> getAllStudies(Pageable pageable);
    Studies getStudiesById(Long studiesId);
    Studies createStudies(Studies studies);
    Studies updateStudies(Long studiesId, Studies studiesRequest);
    ResponseEntity<?> deleteStudies(Long studiesId);
}
