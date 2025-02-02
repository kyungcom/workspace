package com.careerpath.profile.dto;

import com.careerpath.profile.entity.Education;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EducationResponseDto {
    private String school;
    private String degree;
    private String fieldOfStudy;
    private LocalDate from;
    private LocalDate to;

    public EducationResponseDto(Education education) {
        this.school = education.getSchool();
        this.degree = education.getDegree();
        this.fieldOfStudy = education.getFieldOfStudy();
        this.from = education.getFrom();
        this.to = education.getTo();
    }
}
