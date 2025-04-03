package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;

    private final String mail;

    private final String password;

    public SignUpRequestDto(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }
}
