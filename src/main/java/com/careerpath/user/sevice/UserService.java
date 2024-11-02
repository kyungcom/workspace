package com.careerpath.user.sevice;


import com.careerpath.user.entity.User;
import com.careerpath.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(String email, String password, String name) {
        // 중복 체크
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        //유저 생성
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        return userRepository.save(user);
    }




}
