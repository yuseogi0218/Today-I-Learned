package com.example.jwt.config.security.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Setter
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${spring.jwt.secretKey}") // lombok 이 아닌, beans꺼를 사용
    private String secretKey;

    private static final long TOKEN_VALID_TIME = 1000L * 60 * 30; // 30분
    private static final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 7; // 7일

    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String email) {
        Claims claims = Jwts.claims().setSubject(email); // 토큰의 키가 되는 Subject 를 중복되지 않는 고유한 값인 Email 로 지정한다.
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_TIME)) // 만료시간은 지금 시간으로부터 30분을 설정한다.
                .signWith(SignatureAlgorithm.HS256, secretKey) // 서명 알고리즘 지정
                .compact();
    }

    public String createRefreshToken() {
        Date now = new Date();

        return Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 토큰으로 인증 객체 (Authentication)을 얻기 위한 메소드
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getMemberEmail(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // 이메일을 얻기 위해, 실제로 토큰을 디토딩 하는 메소드
    // 지정한 SecretKey 를 통해 서명된 JWT 를 해석하여 Subject 를 끌고와 리턴하여 이를 통해 인증 객체를 끌고 올 수 있다.
    public String getMemberEmail(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e){
            return e.getClaims().getSubject();
        }
    }

    // 토큰은 Http Header 에 저장되어 계속적으로 이용되어진다.
    // 토큰을 사용하기 위해 실제로 Header 에서 꺼내오는 메소드 이다.
    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("X-AUTH-TOKEN");
    }

    // 토큰이 만료되었는지를 확인해주는 메소드이다.
    public boolean validateTokenExpiration(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }


}
