package com.careerpath.profile.dto;

import com.careerpath.auth.dto.UserInfoDto;
import com.careerpath.profile.entity.Profile;
import com.careerpath.user.entity.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ProfileResponseDto {
    private UserInfoDto userInfo;
    private String company;
    private String location;
    private String bio;
    private List<String> skills;
    private List<EducationResponseDto> education;
    private List<ExperienceResponseDto> experience;

    public ProfileResponseDto(Profile profile) {
        this.userInfo = new UserInfoDto(profile.getUser());
        this.company = profile.getCompany();
        this.location = profile.getLocation();
        this.bio = profile.getBio();

        this.skills = profile.getSkills();

        this.experience = profile.getExperiences().stream()
                .map(ExperienceResponseDto::new)
                .toList();

        this.education = profile.getEducations().stream()
                .map(EducationResponseDto::new)
                .toList();


    }
}
