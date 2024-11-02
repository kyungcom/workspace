package com.careerpath.experience.entity;


import com.careerpath.profile.entity.Profile;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;

    private String title;
    private String company;
    private String position;
    private LocalDate from;
    private LocalDate to;
    private Boolean current;
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
