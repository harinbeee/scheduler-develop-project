package com.example.schedulerproject.dto;

import com.example.schedulerproject.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String username;

    private final String title;

    private final String description;

    public ScheduleResponseDto(Long id, String username, String title, String description) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.description=description;

    }

    // 스케줄 전체조회 - 엔티티 Dto로 변환
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(),schedule.getUser().getUsername(), schedule.getTitle(), schedule.getDescription());
    }
}
