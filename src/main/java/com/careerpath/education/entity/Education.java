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

    @Column(name = "from_date")
    private LocalDate from;

    @Column(name = "to_date")
    private LocalDate to;
    private boolean current;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
