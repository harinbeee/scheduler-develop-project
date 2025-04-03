package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.SignUpResponseDto;
import com.example.schedulerproject.dto.UserResponseDto;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

//    **의존성 주입**
    private final UserRepository userRepository;

    // 1. 유저생성 (회원가입)
    public SignUpResponseDto signup(String username, String mail, String password) {

        User user = new User(username, mail, password);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getMail());
    }

    // 2. 유저 조회
    public UserResponseDto findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        // NPE 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 유저 ID = "+ id);
        }
        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getMail());
    }


}
