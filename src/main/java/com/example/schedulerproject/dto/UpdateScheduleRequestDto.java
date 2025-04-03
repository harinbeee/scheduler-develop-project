package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {


    private final String title;

    private final String description;

    // 비밀번호 일치시 삭제
    private final String password;

    public UpdateScheduleRequestDto(String title, String description, String password) {
        this.title = title;
        this.description = description;
        this.password = password;
    }
}
