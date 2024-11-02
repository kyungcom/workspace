package com.careerpath.profile.repository;

import com.careerpath.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserUserId(Long userId);
}
