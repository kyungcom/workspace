package com.careerpath.like.repository;

import com.careerpath.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
