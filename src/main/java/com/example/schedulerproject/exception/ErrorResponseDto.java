package com.example.schedulerproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseDto {

    private final String errorCode;
    private final String message;
    private final String status;

    public static ErrorResponseDto errorResponseDto (final CustomException customException) {
        String errorCode = customException.getErrorCode().getCode();
        String message = customException.getErrorCode().getMessage();
        String status = customException.getStatus();
        return new ErrorResponseDto(errorCode, message, status);
    }

}
