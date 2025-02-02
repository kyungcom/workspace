package com.careerpath.profile.repository;

import com.careerpath.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p LEFT JOIN p.user WHERE p.user.userId = :userId")
    Optional<Profile> findProfileByUserId(@Param("userId") Long userId);
}
