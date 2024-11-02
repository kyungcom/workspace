package com.careerpath.education.repository;

import com.careerpath.education.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
