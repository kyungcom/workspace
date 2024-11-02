package com.careerpath.profile.controller;

import com.careerpath.profile.sevice.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfileByUserId(userId));
    }

    @PostMapping("/me")
    public ResponseEntity<?> getMyProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfileByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<?> saveProfile() {

    }
}
