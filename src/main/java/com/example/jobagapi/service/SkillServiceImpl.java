package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Skill;
import com.example.jobagapi.domain.repository.SkillRepository;
import com.example.jobagapi.domain.service.SkillService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Page<Skill> getAllSkills(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public Skill getSkillById(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(()->new ResourceNotFoundException("Skill","Id",skillId));
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Long skillId, Skill skillRequest) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill","Id",skillId));
        return  skillRepository.save(
                skill.setName(skillRequest.getName())
                .setDescription(skillRequest.getDescription()));
    }


    @Override
    public ResponseEntity<?> deleteSkill(Long skillId) {
        Skill skill=skillRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill","Id",skillId));
        skillRepository.delete(skill);
        return ResponseEntity.ok().build();
    }
}
