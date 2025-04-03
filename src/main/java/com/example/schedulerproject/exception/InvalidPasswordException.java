package com.example.schedulerproject.exception;

public class InvalidPasswordException extends CustomException{
    public InvalidPasswordException(ErrorCode errorCode) {
        super(ErrorCode.INVAILD_PASSWORD);
    }
}
