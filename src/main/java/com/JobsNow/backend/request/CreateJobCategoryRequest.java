package com.JobsNow.backend.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateJobCategoryRequest {
    @NotBlank(message = "Job category name is required")
    private String categoryName;
    @NotNull(message = "Industry ID is required")
    private Integer industryId;
}
