package com.careerpath.profile.dto;

import com.careerpath.profile.entity.Education;
import com.careerpath.profile.entity.Experience;
import com.careerpath.profile.entity.Profile;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ExperienceResponseDto {
    private String company;
    private String position;
    private LocalDate from;
    private LocalDate to;
    private String description;

    public ExperienceResponseDto(Experience experience){
        this.company = experience.getCompany();
        this.position = experience.getPosition();
        this.from = experience.getFrom();
        this.to = experience.getTo();
        this.description = experience.getDescription();
    }

}
