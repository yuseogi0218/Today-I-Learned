package com.example.securityLogin.dto;

import lombok.Data;

@Data
public class UserLoginReq {

    private String loginId;
    private String loginPw;
}
