package com.careerpath.comment.entity;


import com.careerpath.post.entity.Post;
import com.careerpath.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String comment;
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
