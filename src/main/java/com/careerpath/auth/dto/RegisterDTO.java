package com.careerpath.auth.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class RegisterDTO {
    private String email;
    private String password;
    private String name;
}
