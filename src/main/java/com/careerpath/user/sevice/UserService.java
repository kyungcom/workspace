package com.careerpath.user.sevice;


import com.careerpath.auth.dto.LoginDto;
import com.careerpath.auth.dto.RegisterDto;
import com.careerpath.auth.dto.UserInfoDto;
import com.careerpath.auth.jwt.JwtUtil;
import com.careerpath.user.entity.User;
import com.careerpath.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder
            , JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // 회원가입 메서드
    @Transactional
    public User registerUser(RegisterDto registerDTO) {
        // 중복 체크
        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        //유저 생성
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setName(registerDTO.getName());

        return userRepository.save(user);
    }

    // 로그인 검증 메서드
    public String authenticateUser(LoginDto request) {
        // 1. email 기반 계정 탐색
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        // 3. JWT 토큰 생성 후 반환
        return jwtUtil.generateToken(user.getEmail());
    }

    public UserInfoDto getUserDtoByToken(String token) {
        String jwt = token.replace("Bearer ", "");

        if (!jwtUtil.validateToken(jwt)) {
            throw new IllegalArgumentException("Invalid or expired token");
        }

        String email = jwtUtil.extractEmail(jwt);

        return userRepository.findByEmail(email)
                .map(UserInfoDto::new)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

    }




}
