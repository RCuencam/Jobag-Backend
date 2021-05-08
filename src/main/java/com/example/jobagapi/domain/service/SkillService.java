package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface SkillService {

    Page<Skill> getAllSkills(Pageable pageable);
    Skill getSkillById(Long skillId);
    Skill createSkill(Skill skill);
    ResponseEntity<?> deleteSkill(Long skillId);
}
