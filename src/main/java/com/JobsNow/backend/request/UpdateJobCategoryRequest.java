package com.JobsNow.backend.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateJobCategoryRequest {
    private Integer categoryId;
    private String categoryName;
    private Integer industryId;
}
