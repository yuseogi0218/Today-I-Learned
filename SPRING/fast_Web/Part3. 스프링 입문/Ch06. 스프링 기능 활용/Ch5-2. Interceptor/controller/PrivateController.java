package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 인증이 된 회원만 들어올 수 있음
 */
@RestController
@RequestMapping("/api/private")
@Auth
public class PrivateController {

    @GetMapping("/hello")
    public String hello() {
        return "private hello";
    }
}
