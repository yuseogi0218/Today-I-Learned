package com.example.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberRegisterRequestDto {

    private String email;

    private String password;
}
