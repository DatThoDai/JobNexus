package com.JobsNow.backend.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSkillRequest {
    @NotBlank(message = "Skill name is required")
    private String skillName;
}
