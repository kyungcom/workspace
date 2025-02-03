package com.careerpath.post.service;

import com.careerpath.post.dto.PostCountResponseDto;
import com.careerpath.post.dto.PostCommentResponseDto;
import com.careerpath.post.entity.Post;
import com.careerpath.post.repository.PostRepository;
import com.careerpath.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    private PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostCountResponseDto addPost(String text, User loginUser) {
        Post post = Post.builder()
                .text(text)
                .user(loginUser)
                .build();

        Post savedPost = postRepository.save(post);
        return new PostCountResponseDto(savedPost);
    }

    public PostCommentResponseDto getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        return new PostCommentResponseDto(post);
    }

    public List<PostCountResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream().map(PostCountResponseDto::new)
                .toList();
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
