package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.SignUpRequestDto;
import com.example.schedulerproject.dto.SignUpResponseDto;
import com.example.schedulerproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    **의존성 주입**
    private final UserService userService;

    // 1. 회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(
            @RequestBody SignUpRequestDto requestDto
            ) {

        SignUpResponseDto signUpResponseDto =
                userService.signup(requestDto.getUsername(), requestDto.getMail(), requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);

    }



}
