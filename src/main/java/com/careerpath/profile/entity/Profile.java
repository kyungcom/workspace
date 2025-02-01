package com.careerpath.profile.entity;

import com.careerpath.experience.entity.Experience;
import com.careerpath.education.entity.Education;
import com.careerpath.user.entity.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String status;
    private String website;
    private String company;
    private String location;

    @ElementCollection
    private List<String> skills = new ArrayList<>();
    private String githubusername;
    private String bio;
    private String twitter;
    private String facebook;
    private String youtube;
    private String linkedin;
    private String instagram;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "profile")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "profile")
    private List<Education> educations;

}
