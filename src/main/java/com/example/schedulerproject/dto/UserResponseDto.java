package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String username;

    private final String mail;

    public UserResponseDto(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }
}
