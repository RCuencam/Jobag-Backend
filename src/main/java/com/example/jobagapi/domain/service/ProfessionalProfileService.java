package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.model.ProfessionalProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProfessionalProfileService {
    Page<ProfessionalProfile> getAllProfessionalProfileByPostulantId(Long postulantId, Pageable pageable);
    ProfessionalProfile getProfessionalProfileByIdAndPostulantId(Long postulantId, Long professionalprofileId);

    ProfessionalProfile createProfessionalProfile(Long postulantId, ProfessionalProfile professionalProfile);
    ProfessionalProfile updateProfessionalProfile(Long postulantId, Long professionalprofileId, ProfessionalProfile professionalprofileDetails);
    ResponseEntity<?> deleteProfessionalProfile(Long postulantId, Long professionalprofileId);

    ProfessionalProfile assignProfessionalProfileSkill(Long professionalprofileId, Long skillsId);
    ProfessionalProfile unassignProfessionalProfileSkill(Long professionalprofileId, Long skillsId);
    Page<ProfessionalProfile> getAllProfessionalProfileBySkillId(Long skillsId, Pageable pageable);


    ProfessionalProfile assignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId);
    ProfessionalProfile unassignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId);
    Page<ProfessionalProfile> getAllProfessionalProfileByLanguagesId(Long languagesId, Pageable pageable);

    ProfessionalProfile assignProfessionalProfileStudy(Long professionalprofileId, Long studiesId);
    ProfessionalProfile unassignProfessionalProfileStudy(Long professionalprofileId, Long studiesId);
    Page<ProfessionalProfile> getAllProfessionalProfileByStudiesId(Long studiesId, Pageable pageable);

}
