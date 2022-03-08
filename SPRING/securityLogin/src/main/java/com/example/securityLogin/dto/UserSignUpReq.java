package com.example.securityLogin.dto;

import lombok.Data;

@Data
public class UserSignUpReq {

    private String loginId;

    private String loginPw;

    private String name;
}
