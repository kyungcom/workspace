package com.careerpath.auth.controller;

import com.careerpath.auth.dto.JwtResponseDto;
import com.careerpath.auth.dto.LoginDto;
import com.careerpath.auth.dto.RegisterDto;
import com.careerpath.auth.dto.UserInfoDto;
import com.careerpath.auth.jwt.JwtUtil;
import com.careerpath.user.entity.User;
import com.careerpath.user.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthContoller {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@RequestBody RegisterDto registerDTO) {
        User user = userService.registerUser(registerDTO);

        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginDto request) {
        String token = userService.authenticateUser(request);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    @GetMapping
    public ResponseEntity<UserInfoDto> myInfo(@RequestHeader("Authorization") String token) {
        UserInfoDto userDtoByToken = userService.getUserDtoByToken(token);
        return ResponseEntity.ok(userDtoByToken);
    }

}
