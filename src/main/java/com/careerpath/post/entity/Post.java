package com.careerpath.post.entity;


import com.careerpath.comment.entity.Comment;
import com.careerpath.like.entity.Like;
import com.careerpath.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String text;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;
}
