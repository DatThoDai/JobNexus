package com.JobsNow.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jobseeker_skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeekerSkill {
    @EmbeddedId
    private JobSeekerSkillId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("profileId")
    @JoinColumn(name = "profile_id")
    private JobSeekerProfile jobSeekerProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String level;
    private Integer yearsOfExperience;

}
