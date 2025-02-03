package com.careerpath.like.repository;

import com.careerpath.like.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT l FROM Like l WHERE l.user.userId = :userId AND l.post.postId = :postId")
    Optional<Like> findByPostAndUser(@Param("userId") Long userId, @Param("postId") Long postId);
}
