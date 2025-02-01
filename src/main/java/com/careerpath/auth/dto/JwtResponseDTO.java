package com.careerpath.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponseDTO {
    private String token;
}
