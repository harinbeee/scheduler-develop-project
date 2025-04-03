package com.example.schedulerproject.exception;

public class InvalidPasswordException extends CustomException{
    public InvalidPasswordException() {
        super(ErrorCode.INVAILD_PASSWORD);
    }
}
