package com.example.schedulerproject.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String title;

    private final String description;


    public ScheduleRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
