package com.careerpath.post.dto;

import com.careerpath.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostCountResponseDto {
    private Long id;
    private String text;
    private String name;
    private String avatar;
    private Long userId;
    private Integer likeCount;
    private Integer commentCount;
    private LocalDateTime date;

    public PostCountResponseDto(Post post) {
        this.id = post.getPostId();
        this.text = post.getText();
        this.name = post.getUser().getName();
        this.avatar = "temp";
        this.userId = post.getUser().getUserId();
        this.likeCount = post.getLikes().size();
        this.commentCount = post.getComments().size();
        this.date = post.getDate();
    }
}
