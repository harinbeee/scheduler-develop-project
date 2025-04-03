package com.example.schedulerproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException e) {
        ErrorResponseDto errorResponse = ErrorResponseDto.errorResponseDto(e);
        return ResponseEntity.status(e.getStatus()).body(errorResponse);
    }
}
