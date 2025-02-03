package com.careerpath.post.dto;


import com.careerpath.comment.entity.Comment;
import com.careerpath.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostCommentResponseDto {
    private Long id;
    private String text;
    private String name;
    private String avatar;
    private Long userId;
    private List<Comment> comment;
    private LocalDateTime date;

    public PostCommentResponseDto(Post post) {
        this.id = post.getPostId();
        this.text = post.getText();
        this.name = post.getUser().getName();
        this.avatar = "temp";
        this.userId = post.getUser().getUserId();
        this.comment = post.getComments();
        this.date = post.getDate();
    }
}
