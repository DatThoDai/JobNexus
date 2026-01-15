package com.JobsNow.backend.controllers;

import com.JobsNow.backend.request.UpdateJobSeekerSkillsRequest;
import com.JobsNow.backend.request.UpdateProfileRequest;
import com.JobsNow.backend.response.ResponseFactory;
import com.JobsNow.backend.service.JobSeekerProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class JobSeekerProfileController {
    private final JobSeekerProfileService jobSeekerProfileService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllProfiles() {
        return ResponseFactory.success(jobSeekerProfileService.getAllJobSeekerProfiles());
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<?> getProfileById(@PathVariable Integer profileId) {
        return ResponseFactory.success(jobSeekerProfileService.getProfileById(profileId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Integer userId){
        return ResponseFactory.success(jobSeekerProfileService.getProfileByUserId(userId));
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer profileId, @RequestBody UpdateProfileRequest request){
        jobSeekerProfileService.updateProfile(profileId, request);
        return ResponseFactory.successMessage("Profile updated successfully");
    }

    @PostMapping("/{profileId}/avatar")
    public ResponseEntity<?> uploadAvatar(@PathVariable Integer profileId, @RequestParam("avatarFile") MultipartFile avatarFile){
        jobSeekerProfileService.uploadAvatar(profileId, avatarFile);
        return ResponseFactory.successMessage("Avatar uploaded successfully");
    }

    @PutMapping("/skills")
    public ResponseEntity<?> updateSkills(@RequestBody UpdateJobSeekerSkillsRequest request){
        jobSeekerProfileService.updateSkills(request);
        return ResponseFactory.successMessage("Skills updated successfully");
    }
}
