package com.careerpath.profile.controller;

import com.careerpath.profile.dto.EducationRequestDto;
import com.careerpath.profile.dto.ExperienceRequestDto;
import com.careerpath.profile.dto.ProfileRequestDto;
import com.careerpath.profile.dto.ProfileResponseDto;
import com.careerpath.profile.entity.Profile;
import com.careerpath.profile.sevice.ProfileService;
import com.careerpath.user.security.UserDetailImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Void> addProfile(@RequestBody ProfileRequestDto profileRequestDto) {
        UserDetailImpl principal = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        profileService.addProfile(profileRequestDto, principal);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/education")
    public ResponseEntity<Void> addEducation(@RequestBody EducationRequestDto educationRequestDto) {
        UserDetailImpl principal = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        profileService.addEducation(educationRequestDto, principal);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/experience")
    public ResponseEntity<?> addMyExperience(@RequestBody ExperienceRequestDto experienceRequestDto) {
        UserDetailImpl userDetailImpl = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        profileService.addExperience(experienceRequestDto, userDetailImpl);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/experience/{experienceId}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long experienceId) {
        profileService.deleteExperience(experienceId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/education/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) {
        profileService.deleteEducation(educationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfileResponseDtoByUserId(userId));
    }

    @PostMapping("/me")
    public ResponseEntity<?> getMyProfile() {
        UserDetailImpl userDetailImpl = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ProfileResponseDto profileResponseDto = profileService.getProfileResponseDtoByUserId(userDetailImpl.getUser().getUserId());
        return ResponseEntity.ok(profileResponseDto);
    }


}
