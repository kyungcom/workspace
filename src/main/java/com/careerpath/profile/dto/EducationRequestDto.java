package com.careerpath.profile.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EducationRequestDto {
    private String school;
    private String degree;
    private String fieldOfStudy;
    private LocalDate from;
    private LocalDate to;
    private Boolean current;
}
