package com.careerpath.profile.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
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
    private Boolean current;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
