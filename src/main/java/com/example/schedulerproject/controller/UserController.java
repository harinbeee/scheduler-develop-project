package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.SignUpRequestDto;
import com.example.schedulerproject.dto.SignUpResponseDto;
import com.example.schedulerproject.dto.UserResponseDto;
import com.example.schedulerproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    **의존성 주입**
    private final UserService userService;

    // 1. 유저 생성 (회원가입)
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signup(requestDto.getUsername(), requestDto.getMail(), requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 2. 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById (@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }



}
