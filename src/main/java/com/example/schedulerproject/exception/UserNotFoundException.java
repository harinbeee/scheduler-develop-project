package com.example.schedulerproject.exception;

public class UserNotFoundException extends CustomException{
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
