package com.careerpath.post.controller;

import com.careerpath.comment.service.CommentService;
import com.careerpath.like.service.LikeService;
import com.careerpath.post.service.PostService;
import com.careerpath.user.security.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    private LikeService likeService;
    private CommentService commentService;

    @Autowired
    private PostController(PostService postService, LikeService likeService,
                           CommentService commentService) {
        this.postService = postService;
        this.likeService = likeService;
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody String text) {
        UserDetailImpl principal = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(postService.addPost(text, principal.getUser()));
    }

    @GetMapping
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPost(@RequestParam Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @DeleteMapping("/postId")
    public ResponseEntity<Void> deletePost(@RequestParam Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/like/{postId}")
    public ResponseEntity<Void> likePost(@RequestParam Long postId) {
        UserDetailImpl principal = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        likeService.Like(postId, principal.getUser());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/unlike/{postId}")
    public ResponseEntity<Void> unlikePost(@RequestParam Long postId) {
        UserDetailImpl principal = (UserDetailImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        likeService.Unlike(postId, principal.getUser());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<Void> addComment(@RequestParam Long postId, @RequestBody String text) {
        commentService.addComment(postId, text);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comment/{postId}/{commentId}")
    public ResponseEntity<Void> addComment(@RequestParam Long postId, @RequestParam Long commentId) {
        commentService.deleteComment(postId, commentId);
        return ResponseEntity.ok().build();
    }

}
