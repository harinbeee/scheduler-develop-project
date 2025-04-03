package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String username;

    private final String mail;

    public SignUpResponseDto(Long id, String username, String mail) {
        this.id = id;
        this.username = username;
        this.mail = mail;
    }
}
