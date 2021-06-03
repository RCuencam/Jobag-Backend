package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.*;
import com.example.jobagapi.domain.repository.*;
import com.example.jobagapi.domain.service.ProfessionalProfileService;
import com.example.jobagapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalProfileImpl implements ProfessionalProfileService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private StudiesRepository studiesRepository;

    @Autowired
    private LanguagesRepository languagesRepository;

    @Autowired
    private ProfessionalProfileRepository professionalprofileRepository;


    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByPostulantId(Long postulantId, Pageable pageable) {
        return professionalprofileRepository.findByPostulantId(postulantId,pageable);
    }

    @Override
    public ProfessionalProfile getProfessionalProfileByIdAndPostulantId(Long postulantId, Long professionalprofileId) {
        return professionalprofileRepository.findByIdAndPostulantId(postulantId,professionalprofileId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Lead not found with Id" + professionalprofileId+
                                "and PostulantId" + postulantId));
    }

    @Override
    public ProfessionalProfile assignProfessionalProfileSkill(Long professionalprofileId, Long skillsId) {
        Skill skills = skillRepository.findById(skillsId)
                .orElseThrow(() -> new ResourceNotFoundException("Skills", "Id", skillsId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addSkill(skills)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));
    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileSkill(Long professionalprofileId, Long skillsId) {
        Skill skills = skillRepository.findById(skillsId)
                .orElseThrow(() -> new ResourceNotFoundException("Skills", "Id", skillsId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeSkill(skills)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileBySkillId(Long skillsId, Pageable pageable) {
        return skillRepository.findById(skillsId).map(skills -> {
            List<ProfessionalProfile> professionalprofiles = skills.getProfessionalprofiles();
            int profilesCount = professionalprofiles.size();
            return new PageImpl<>(professionalprofiles, pageable, profilesCount); })
                .orElseThrow(() -> new ResourceNotFoundException("Skills", "Id", skillsId));
    }


    @Override
    public ProfessionalProfile assignProfessionalProfileStudy(Long professionalprofileId, Long studiesId) {
        Studies studies = studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies", "Id", studiesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addStudies(studies)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));
    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileStudy(Long professionalprofileId, Long studiesId) {
        Studies studies = studiesRepository.findById(studiesId)
                .orElseThrow(() -> new ResourceNotFoundException("Studies", "Id", studiesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeStudies(studies)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByStudiesId(Long studiesId, Pageable pageable) {
        return studiesRepository.findById(studiesId).map(studies -> {
            List<ProfessionalProfile> professionalprofiles = studies.getProfessionalprofiles();
            int profilesCount = professionalprofiles.size();
            return new PageImpl<>(professionalprofiles, pageable, profilesCount); })
                .orElseThrow(() -> new ResourceNotFoundException("Studies", "Id", studiesId));
    }

    @Override
    public ProfessionalProfile assignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId) {
        Languages languages = languagesRepository.findById(languagesId)
                .orElseThrow(() -> new ResourceNotFoundException("Languages", "Id", languagesId));
        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.addLanguages(languages)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public ProfessionalProfile unassignProfessionalProfileLanguage(Long professionalprofileId, Long languagesId) {
        Languages languages = languagesRepository.findById(languagesId)
                .orElseThrow(() -> new ResourceNotFoundException("Languages", "Id", languagesId));

        return professionalprofileRepository.findById(professionalprofileId).map(
                professionalprofile -> professionalprofileRepository.save(professionalprofile.removeLanguages(languages)))
                .orElseThrow(() -> new ResourceNotFoundException("ProfessionalProfile", "Id", professionalprofileId));

    }

    @Override
    public Page<ProfessionalProfile> getAllProfessionalProfileByLanguagesId(Long languagesId, Pageable pageable) {
        return languagesRepository.findById(languagesId).map(languages -> {
            List<ProfessionalProfile> professionalprofiles = languages.getProfessionalprofiles();
            int profilesCount = professionalprofiles.size();
            return new PageImpl<>(professionalprofiles, pageable, profilesCount); })
                .orElseThrow(() -> new ResourceNotFoundException("Languages", "Id", languagesId));
    }

    @Override
    public ProfessionalProfile createProfessionalProfile(Long postulantId, ProfessionalProfile professionalProfile) {
        return postulantRepository.findById(postulantId).map(postulant -> {

            professionalProfile.setPostulant(postulant);
            return professionalprofileRepository.save(professionalProfile);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Postulant", "Id",postulantId));
    }

    @Override
    public ProfessionalProfile updateProfessionalProfile(Long postulantId, Long professionalprofileId, ProfessionalProfile professionalprofileDetails) {
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return professionalprofileRepository.findById(professionalprofileId).map(professionalProfile -> {
            professionalProfile.setDescription(professionalprofileDetails.getDescription());
            return professionalprofileRepository.save(professionalProfile);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "ProfessionalProfile","Id",professionalprofileId));

    }

    @Override
    public ResponseEntity<?> deleteProfessionalProfile(Long postulantId, Long professionalprofileId) {
        if (!professionalprofileRepository.existsById(professionalprofileId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);

        return professionalprofileRepository.findById(professionalprofileId).map(professionalProfile -> {
            professionalprofileRepository.delete(professionalProfile);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "Company", "Id",professionalprofileId));


    }

}
