package com.example.jwt.controller;

import com.example.jwt.dto.*;
import com.example.jwt.result.SingleResult;
import com.example.jwt.service.ResponseService;
import com.example.jwt.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final SignService signService;
    private final ResponseService responseService;

    @PostMapping("/register")
    public SingleResult<MemberRegisterResponseDto> register(@RequestBody MemberRegisterRequestDto request) {
        MemberRegisterResponseDto response = signService.registerMember(request);
        return responseService.getSingleResult(response);
    }

    @PostMapping("login")
    public SingleResult<MemberLoginResponseDto> login(@RequestBody MemberLoginRequestDto request) {
        MemberLoginResponseDto response = signService.loginMember(request);
        return responseService.getSingleResult(response);
    }

    @PostMapping("/reissue")
    public SingleResult<TokenResponseDto> reIssue(@RequestBody TokenReIssueRequestDto tokenReIssueRequestDto) {
        TokenResponseDto response = signService.reIssue(tokenReIssueRequestDto);
        return responseService.getSingleResult(response);
    }
}
