package com.careerpath.profile.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProfileRequestDto {
    private String company;
    private String website;
    private String location;
    private String bio;
    private String status;
    private String githubUsername;
    private List<String> skills;
    private String youtube;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String instagram;
}
