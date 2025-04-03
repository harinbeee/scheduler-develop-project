package com.example.schedulerproject.exception;

public class UserNotFoundException extends CustomException{
    public UserNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
