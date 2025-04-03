package com.example.schedulerproject.exception;

public class LoginFailException extends CustomException {
    public LoginFailException(ErrorCode errorCode) {
        super(ErrorCode.LOGIN_FAILED);
    }
}
