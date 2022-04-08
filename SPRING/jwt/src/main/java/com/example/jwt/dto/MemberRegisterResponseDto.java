package com.example.jwt.dto;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberRegisterResponseDto {

    @ApiParam(value = "로그인 PK", required = true) // for swagger
    private Long id;

    @ApiParam(value = "로그인 아이디", required = true)
    private String email;

    @Builder
    public MemberRegisterResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
