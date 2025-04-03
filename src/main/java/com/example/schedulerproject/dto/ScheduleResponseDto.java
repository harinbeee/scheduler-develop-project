package com.example.schedulerproject.dto;

import com.example.schedulerproject.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String username;

    public ScheduleResponseDto(Long id, String title, String username) {
        this.id = id;
        this.title = title;
        this.username = username;
    }

    // 스케줄 전체조회 - 엔티티 Dto로 변환
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getDescription());
    }
}
