package com.example.securityLogin.controller;

import com.example.securityLogin.dto.UserLoginReq;
import com.example.securityLogin.dto.UserLoginRes;
import com.example.securityLogin.dto.UserSignUpReq;
import com.example.securityLogin.service.UserSignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(("/user/sign"))
public class UserSignController {

    private final UserSignService userSignService;

    @PostMapping("/")
    public void create(@RequestBody UserSignUpReq userSignUpReq) {
        userSignService.signUp(userSignUpReq);
    }

    @GetMapping("/")
    public UserLoginRes login(@RequestBody UserLoginReq userLoginReq) {
        return userSignService.login(userLoginReq);
    }
}
