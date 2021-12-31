package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.exception") // 범위 설정
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class) // 처리할 예외 설정
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class) // 처리할 예외 설정
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println(e.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
