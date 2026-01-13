package com.JobsNow.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobCategoryDTO {
    private Integer categoryId;
    private String categoryName;
    private Integer industryId;
    private String industryName;
}
