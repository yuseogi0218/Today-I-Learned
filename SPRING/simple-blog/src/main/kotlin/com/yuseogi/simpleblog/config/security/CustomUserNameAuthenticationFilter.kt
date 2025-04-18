package com.yuseogi.simpleblog.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.yuseogi.simpleblog.domain.member.MemberDto
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class CustomUserNameAuthenticationFilter(
    private val objectMapper: ObjectMapper
) : UsernamePasswordAuthenticationFilter() {

    private val log = KotlinLogging.logger {  }

    private val jwtManager = JwtManager()

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        log.info { "login 요청 옴" }

        lateinit var memberDto: MemberDto

        try {
            memberDto = objectMapper.readValue(request?.inputStream, MemberDto::class.java)
            log.info { "login Dto : $memberDto" }
        } catch (e: Exception) {
            log.error { "loginFilter: 로그인 요청 Dto 생성 중 실패! $e" }
        }

        val authenticationToken = UsernamePasswordAuthenticationToken(memberDto.email, memberDto.password)

        return this.authenticationManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        log.info { "login 완료 후, JWT 토큰 생성하여 응답" }

        val principalDetails = authResult?.principal as PrincipalDetails
        val jwtToken = jwtManager.generateAccessToken(principalDetails)

        response?.addHeader(jwtManager.jwtHeader, "Bearer $jwtToken")
    }
}