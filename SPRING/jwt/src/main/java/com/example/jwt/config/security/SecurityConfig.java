package com.example.jwt.config.security;

import com.example.jwt.config.security.AccessDeniedHandler.CustomAccessDeniedHandler;
import com.example.jwt.config.security.AuthenticationEntryPoint.CustomAuthenticationEntryPoint;
import com.example.jwt.config.security.jwt.JwtAuthenticationFilter;
import com.example.jwt.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable() // rest api 이므로 기본 설정 미사용
                .csrf().disable() // rest api이므로 csrt보안 미사용
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt로 인증하므로 세션 미 사용
                .and()
                .authorizeRequests()
                .antMatchers("/sign/**").permitAll()
                .antMatchers("/social/**").permitAll()
                .antMatchers("/exception/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 인증이 되지 않은 채로 인증이 필요한 페이지에 접근했을 시 발생하는 Exception 처리
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()) // 권한이 없는데 권한이 필요한 페이지에 접근했을 때 발생하는 Exception 처리
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); // jwt 필터 추가
    }
}
