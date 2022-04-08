package com.example.jwt.controller;

import com.example.jwt.advice.exception.AccessDeniedException;
import com.example.jwt.advice.exception.AuthenticationEntryPointException;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @ApiOperation(value = "인증 실패", notes = "인증 실패에 따른 예외가 발생하였습니다.")
    @GetMapping("/entry")
    public void EntryPointException() {
        throw new AuthenticationEntryPointException();
    }

    @ApiOperation(value = "인가 거부", notes = "인가에 따른 예외가 발생하였습니다.")
    @GetMapping("/denied")
    public void AccessDeniedException() {
        throw new AccessDeniedException();
    }
}
