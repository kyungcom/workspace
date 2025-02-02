package com.careerpath.profile.repository;

import com.careerpath.profile.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
