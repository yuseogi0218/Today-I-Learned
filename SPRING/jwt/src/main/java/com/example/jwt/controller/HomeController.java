package com.example.jwt.controller;

import com.example.jwt.service.SignService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HomeController {

    private final SignService signService;

    @ApiOperation(value = "테스트 페이지", notes = "인증을 위한 테스트 페이지")
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
