package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SkillService {
    Page<Skill> getAllSkills(Pageable pageable);
    Skill getSkillById(Long skillId);
    Skill createSkill(Skill skill);
    Skill updateSkill(Long skillId, Skill skillRequest);
    ResponseEntity<?> deleteSkill(Long skillId);
}
