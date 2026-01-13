package com.JobsNow.backend.controllers;

import com.JobsNow.backend.request.CreateJobCategoryRequest;
import com.JobsNow.backend.request.UpdateJobCategoryRequest;
import com.JobsNow.backend.response.BaseResponse;
import com.JobsNow.backend.service.JobCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class JobCategoryController {
    private final JobCategoryService jobCategoryService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllJobCategories() {
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMessage("Job categories retrieved successfully");
        response.setData(jobCategoryService.getAllJobCategories());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/industry/{industryId}")
    public ResponseEntity<?> getJobCategoriesByIndustryId(@PathVariable Integer industryId){
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMessage("Job categories retrieved successfully");
        response.setData(jobCategoryService.getJobCategoriesByIndustryId(industryId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJobCategory(@RequestBody CreateJobCategoryRequest request){
        BaseResponse response = new BaseResponse();
        jobCategoryService.addJobCategory(request);
        response.setCode(200);
        response.setMessage("Job category added successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateJobCategory(@RequestBody UpdateJobCategoryRequest request){
        BaseResponse response = new BaseResponse();
        jobCategoryService.updateJobCategory(request);
        response.setCode(200);
        response.setMessage("Job category updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<?> deleteJobCategory(@PathVariable Integer categoryId){
        BaseResponse response = new BaseResponse();
        jobCategoryService.deleteJobCategory(categoryId);
        response.setCode(200);
        response.setMessage("Job category deleted successfully");
        return ResponseEntity.ok(response);
    }

}
