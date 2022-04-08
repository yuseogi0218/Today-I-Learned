package com.example.jwt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponseDto {

    private String accessToken;

    private String refreshToken;
}
