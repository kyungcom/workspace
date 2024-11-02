package com.careerpath.education.entity;


import com.careerpath.profile.entity.Profile;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    private String school;
    private String degree;
    private String fieldOfStudy;
    private LocalDate from;
    private LocalDate to;
    private boolean current;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
