package com.careerpath.experience.repository;

import com.careerpath.experience.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRespository extends JpaRepository<Experience, Long> {

}
