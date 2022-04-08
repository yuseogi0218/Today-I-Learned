package com.example.jwt.advice.exception;

public class LoginFailureException extends RuntimeException {
    public LoginFailureException() {
    }

    public LoginFailureException(String messsage) {
        super(messsage);
    }

    public LoginFailureException(String message, Throwable cause) {
        super(message, cause);
    }

}
