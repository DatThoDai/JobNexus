package com.JobsNow.backend.repositories;

import com.JobsNow.backend.entity.JobSeekerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerSkillRepository extends JpaRepository<JobSeekerSkill, Integer> {
    void deleteByJobSeekerProfile_ProfileId(Integer profileId);
}
