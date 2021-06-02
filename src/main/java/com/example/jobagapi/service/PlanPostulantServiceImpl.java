package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.PlanPostulant;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.PlanPostulantRepository;
import com.example.jobagapi.domain.repository.PlanemployeerRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PlanPostulantService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanPostulantServiceImpl implements PlanPostulantService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private PlanPostulantRepository planPostulantRepository;

    @Override
    public Page<PlanPostulant> getAllPlanPostulantsByPostulantId(Long postulantId, Pageable pageable) {
        return planPostulantRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public PlanPostulant getPlanPostulantByIdAndPostulantId(Long planpostulantId, Long postulantId) {
        return planPostulantRepository.findByIdAndPostulantId(planpostulantId,postulantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + planpostulantId+
                                "and PostulantId" + postulantId));
    }

    @Override
    public PlanPostulant createPlanPostulant(Long postulantId, PlanPostulant planpostulant) {
        return postulantRepository.findById(postulantId).map(postulant -> {
            planpostulant.setPostulant(postulant);
            return planPostulantRepository.save(planpostulant);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Postulant", "Id",postulantId));
    }

    @Override
    public PlanPostulant updatePlanPostulant(Long postulantId, Long planpostulantId, PlanPostulant planpostulantDetails) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return planPostulantRepository.findById(planpostulantId).map(planpostulant -> {

            planpostulant.setDescription(planpostulantDetails.getDescription())
                    .setLimit_postulations(planpostulantDetails.getLimit_postulations())
                    .setLimit_videocreation(planpostulantDetails.getLimit_videocreation())
                    .setPre_design_templates(planpostulantDetails.isPre_design_templates())
                    .setDuration(planpostulantDetails.getDuration())

            ;

            return planPostulantRepository.save(planpostulant);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "PlanPostulant","Id",planpostulantId));
    }

    @Override
    public ResponseEntity<?> deletePlanPostulant(Long postulantId, Long planpostulantId) {
        if (!planPostulantRepository.existsById(planpostulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return planPostulantRepository.findById(planpostulantId).map(planpostulant -> {
            planPostulantRepository.delete(planpostulant);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "PlanPostulant", "Id",planpostulantId));
    }
}
