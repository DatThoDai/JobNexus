package com.JobsNow.backend.service;

import com.JobsNow.backend.dto.JobSeekerProfileDTO;
import com.JobsNow.backend.request.UpdateJobSeekerSkillsRequest;
import com.JobsNow.backend.request.UpdateProfileRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerProfileService {
    List<JobSeekerProfileDTO> getAllJobSeekerProfiles();
    JobSeekerProfileDTO getProfileById(Integer profileId);
    JobSeekerProfileDTO getProfileByUserId(Integer userId);
    void updateProfile(Integer profileId, UpdateProfileRequest request);
    void uploadAvatar(Integer profileId, MultipartFile avatarFile);
    void updateSkills(UpdateJobSeekerSkillsRequest request);
}
