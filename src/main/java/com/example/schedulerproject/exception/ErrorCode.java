package com.example.schedulerproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND("U001", "유저를 찾을 수 없습니다", HttpStatus.NOT_FOUND),
    SCHEDULE_NOT_FOUND("S001","스케줄을 찾을 수 없습니다", HttpStatus.NOT_FOUND),
    LOGIN_FAILED("C001","이메일 또는 비밀번호가 일치하지 않습니다", HttpStatus.BAD_REQUEST),
    INVAILD_PASSWORD("U002","비밀번호가 일치하지 않습니다", HttpStatus.UNAUTHORIZED);


    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {

        this.code = code;
        this.message = message;
        this.status = status;
    }
}
