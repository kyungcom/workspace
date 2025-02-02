package com.careerpath.profile.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;

    private String title;
    private String company;
    private String position;

    @Column(name = "from_date")
    private LocalDate from;
    @Column(name = "to_date")
    private LocalDate to;

    private Boolean current;
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
