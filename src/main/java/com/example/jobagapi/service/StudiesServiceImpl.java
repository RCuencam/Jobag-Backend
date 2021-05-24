package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Sector;
import com.example.jobagapi.domain.model.Studies;
import com.example.jobagapi.domain.repository.StudiesRepository;
import com.example.jobagapi.domain.service.StudiesService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudiesServiceImpl implements StudiesService {
    @Autowired
    private StudiesRepository studiesRepository;

    @Override
    public Page<Studies> getAllStudies(Pageable pageable) { return studiesRepository.findAll(pageable);  }

    @Override
    public Studies getStudiesById(Long studiesId) {
        return studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies","Id",studiesId));
    }

    @Override
    public Studies createStudies(Studies studies) { return studiesRepository.save(studies); }

    @Override
    public Studies updateStudies(Long studiesId, Studies studiesRequest) {
        Studies studies = studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies","Id",studiesId));
        return studiesRepository.save(
                studies.setName(studiesRequest.getName())
                        .setDegree(studiesRequest.getDegree()));
    }

    @Override
    public ResponseEntity<?> deleteStudies(Long studiesId) {
       Studies studies = studiesRepository.findById(studiesId)
               .orElseThrow(() -> new ResourceNotFoundException("Studies","Id",studiesId));
       studiesRepository.delete(studies);
       return ResponseEntity.ok().build();
    }
}
