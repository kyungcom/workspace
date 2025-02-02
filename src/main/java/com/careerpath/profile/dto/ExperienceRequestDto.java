package com.careerpath.profile.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ExperienceRequestDto {
    private String title;
    private String company;
    private String position;
    private LocalDate from;
    private LocalDate to;
    private Boolean current;
    private String description;
}
