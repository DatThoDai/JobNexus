package com.JobsNow.backend.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class UpdateJobSeekerSkillsRequest {
    @NotNull(message = "Profile ID cannot be null")
    private Integer profileId;
    private List<SkillItem> skills;
    @Data
    public static class SkillItem {
        @NotNull(message = "Skill ID cannot be null")
        private Integer skillId;

        private String level;
        private Integer yearsOfExperience;
    }
}
