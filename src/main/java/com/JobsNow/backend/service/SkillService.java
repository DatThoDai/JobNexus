package com.JobsNow.backend.service;

import com.JobsNow.backend.dto.SkillDTO;
import com.JobsNow.backend.request.CreateSkillRequest;

import java.util.List;

public interface SkillService {
    List<SkillDTO> getAllSkills();
    void addSkill(CreateSkillRequest addSkillRequest);
    void updateSkill(Integer skillId, String skillName);
    void deleteSkill(Integer skillId);
}
