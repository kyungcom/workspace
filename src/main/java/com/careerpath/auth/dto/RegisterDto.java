package com.careerpath.auth.dto;

import lombok.Getter;

@Getter
public class RegisterDto {
    private String email;
    private String password;
    private String name;
}
