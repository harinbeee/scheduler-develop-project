package com.example.schedulerproject.service;

import com.example.schedulerproject.dto.SignUpResponseDto;
import com.example.schedulerproject.dto.UserResponseDto;
import com.example.schedulerproject.entity.User;
import com.example.schedulerproject.exception.InvalidPasswordException;
import com.example.schedulerproject.exception.LoginFailException;
import com.example.schedulerproject.exception.UserNotFoundException;
import com.example.schedulerproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
            throw new UserNotFoundException();
        }

        // 찾는 유저가 없을때


        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getMail());
    }

    // 3. 유저 수정 - 비밀번호 일치시, 비밀번호 수정
    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new InvalidPasswordException();
        }

        findUser.updatePassword(newPassword);
    }

    // 4. 유저 삭제 - 비밀번호 일치시
    public void deleteUser(Long id, String password){
        // 비밀번호 확인 - id로 유저찾기
        User findUser = userRepository.findByIdOrElseThrow(id);
        // 비밀번호 확인 - 예외 처리
        if(!findUser.getPassword().equals(password)){
            throw new InvalidPasswordException();
        }

       userRepository.delete(findUser);
    }


//    **로그인**
    // 이메일, 비밀번호로 로그인
    public UserResponseDto login (final String mail, final String password) {
        // 이메일로 회원정보 조회
        User user = userRepository.findUserByMail(mail);
        String usersPassword = (user==null) ? "" : user.getPassword();

        if(user == null || !usersPassword.equals(password)){
            throw new LoginFailException();
        }

        return new UserResponseDto(user.getUsername(), user.getMail());
    }


}
