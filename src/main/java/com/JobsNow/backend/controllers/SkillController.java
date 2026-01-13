package com.JobsNow.backend.controllers;

import com.JobsNow.backend.request.CreateSkillRequest;
import com.JobsNow.backend.response.BaseResponse;
import com.JobsNow.backend.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllSkills() {
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMessage("Skills retrieved successfully");
        response.setData(skillService.getAllSkills());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSkill(@RequestBody CreateSkillRequest request){
        BaseResponse response = new BaseResponse();
        skillService.addSkill(request);
        response.setCode(200);
        response.setMessage("Skill added successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{skillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Integer skillId) {
        BaseResponse response = new BaseResponse();
        skillService.deleteSkill(skillId);
        response.setCode(200);
        response.setMessage("Skill deleted successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSkill(@RequestParam Integer skillId, @RequestParam String skillName) {
        BaseResponse response = new BaseResponse();
        skillService.updateSkill(skillId, skillName);
        response.setCode(200);
        response.setMessage("Skill updated successfully");
        return ResponseEntity.ok(response);
    }
}
