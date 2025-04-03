package com.example.schedulerproject.exception;

public class LoginFailException extends CustomException {
    public LoginFailException() {
        super(ErrorCode.LOGIN_FAILED);
    }
}
