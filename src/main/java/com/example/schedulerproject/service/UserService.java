package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.SignUpResponseDto;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

//    **의존성 주입**
    private final UserRepository userRepository;

    public SignUpResponseDto signup(String username, String mail, String password) {

        User user = new User(username, mail, password);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getMail());

    }
}
