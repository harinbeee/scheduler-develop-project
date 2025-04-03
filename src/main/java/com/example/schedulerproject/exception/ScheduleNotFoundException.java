package com.example.schedulerproject.exception;

public class ScheduleNotFoundException extends CustomException {
    public ScheduleNotFoundException() {
        super(ErrorCode.SCHEDULE_NOT_FOUND);
    }
}
