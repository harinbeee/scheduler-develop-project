package com.example.schedulerproject.controller;

import com.example.schedulerproject.dto.*;
import com.example.schedulerproject.exception.LoginFailException;
import com.example.schedulerproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    // 3. 유저 수정 - 비밀번호 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ) {

        userService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 4. 유저 삭제 - 비밀번호 일치시
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id,
            @RequestBody DeleteRequestDto requestDto
    ){
        userService.deleteUser(id, requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    **로그인 관련**
    // 1. 로그인
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(
            @RequestBody LoginRequestDto loginDto,
            HttpServletRequest request
    ) {
        UserResponseDto userResponseDto = userService.login(loginDto.getMail(), loginDto.getPassword());

        if (userResponseDto == null) {
            throw new LoginFailException();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loginUser",userResponseDto);
        session.setMaxInactiveInterval(60*30);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
