package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class DeleteRequestDto {


    // 비밀번호 일치시 수정
    private final String password;

    public DeleteRequestDto(String password) {
        this.password = password;
    }
}
