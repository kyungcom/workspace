package com.careerpath.like.service;

import com.careerpath.like.entity.Like;
import com.careerpath.like.repository.LikeRepository;
import com.careerpath.post.entity.Post;
import com.careerpath.post.repository.PostRepository;
import com.careerpath.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }

    public void Like(Long postId, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        Like like = Like.builder()
                .post(post)
                .user(user)
                .build();

        likeRepository.save(like);
    }

    public void Unlike(Long postId, User user) {
        Like like = likeRepository.findByPostAndUser(postId, user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Like not found"));

        likeRepository.delete(like);
    }
}
