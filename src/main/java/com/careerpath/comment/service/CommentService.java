package com.careerpath.comment.service;


import com.careerpath.comment.entity.Comment;
import com.careerpath.comment.repository.CommentRepository;
import com.careerpath.post.entity.Post;
import com.careerpath.post.repository.PostRepository;
import com.careerpath.user.entity.User;
import com.careerpath.user.security.UserDetailImpl;
import com.careerpath.user.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void addComment(Long postId, String text) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        UserDetailImpl principal = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Comment comment = Comment.builder()
                .comment(text)
                .post(post)
                .user(principal.getUser())
                .build();

        commentRepository.save(comment);

    }

    public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        if (comment.getPost().getPostId().equals(postId)) {
            commentRepository.delete(comment);
        } else {
            throw new IllegalArgumentException("PostId and CommentId not matched");
        }


    }
}
