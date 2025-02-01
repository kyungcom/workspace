package com.careerpath.auth.dto;

import com.careerpath.user.entity.User;
import lombok.Data;
import lombok.Getter;

@Getter
public class UserInfoDto {
    private Long id;
    private String name;
    private String email;
    private String avatar;

    public UserInfoDto(User user) {
        this.id = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.avatar = "temp";
    }

}
