package com.example.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenReIssueRequestDto {

    private String email;

    private String refreshToken;
}
