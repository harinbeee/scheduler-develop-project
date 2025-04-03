package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String title;

    private final String description;

    private final String username;

    public ScheduleRequestDto(String title, String description, String username) {
        this.title = title;
        this.description = description;
        this.username = username;
    }
}
