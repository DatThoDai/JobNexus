package com.JobsNow.backend.service;

import com.JobsNow.backend.dto.JobCategoryDTO;
import com.JobsNow.backend.request.CreateJobCategoryRequest;
import com.JobsNow.backend.request.UpdateJobCategoryRequest;

import java.util.List;

public interface JobCategoryService {
    List<JobCategoryDTO> getAllJobCategories();
    List<JobCategoryDTO> getJobCategoriesByIndustryId(Integer industryId);
    void addJobCategory(CreateJobCategoryRequest request);
    void updateJobCategory(UpdateJobCategoryRequest request);
    void deleteJobCategory(Integer categoryId);

}
