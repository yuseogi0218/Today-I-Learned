package com.example.jwt.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberLoginResponseDto {

    private Long id;

    private String token;

}
