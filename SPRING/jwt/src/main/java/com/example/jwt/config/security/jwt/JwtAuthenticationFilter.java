package com.example.jwt.config.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        // 토큰 유효성 및 만료시간 확인
        if (token != null && jwtTokenProvider.validateTokenExpiration(token)) {
            // 인증 객체를 받아온다.
            Authentication auth = jwtTokenProvider.getAuthentication(token);

            // SecurityContextHolder 에 인증객체를 저장하여 인증을 할 수 있도록 한다.
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // 다음 필터로 넘어가 실제 AuthenticationFilter 에서 이미 인증되어 있는 객체를 통해 인증이 되게 된다.
        chain.doFilter(request, response);
    }
}
