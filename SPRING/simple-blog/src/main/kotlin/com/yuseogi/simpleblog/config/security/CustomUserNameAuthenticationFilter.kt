package com.yuseogi.simpleblog.config.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.yuseogi.simpleblog.domain.member.MemberDto
import com.yuseogi.simpleblog.util.CookieProvider
import com.yuseogi.simpleblog.util.func.responseData
import com.yuseogi.simpleblog.util.value.CmResDto
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.concurrent.TimeUnit

class CustomUserNameAuthenticationFilter(
    private val objectMapper: ObjectMapper
) : UsernamePasswordAuthenticationFilter() {

    private val log = KotlinLogging.logger {  }

    private val jwtManager = JwtManager()

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        log.debug { "login 요청 옴" }

        lateinit var memberDto: MemberDto

        try {
            memberDto = objectMapper.readValue(request?.inputStream, MemberDto::class.java)
            log.debug { "login Dto : $memberDto" }
        } catch (e: Exception) {
            log.error { "loginFilter: 로그인 요청 Dto 생성 중 실패! $e" }
        }

        val authenticationToken = UsernamePasswordAuthenticationToken(memberDto.email, memberDto.rawPassword)

        return this.authenticationManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse, chain: FilterChain?, authResult: Authentication?) {
        log.debug { "login 완료 후, JWT 토큰 생성하여 응답" }

        val principalDetails = authResult?.principal as PrincipalDetails
        val accessToken = jwtManager.generateAccessToken(objectMapper.writeValueAsString(principalDetails))
        response.addHeader(jwtManager.authorizationHeader, jwtManager.jwtHeader +  accessToken)

        val refreshToken = jwtManager.generateRefreshToken(objectMapper.writeValueAsString(principalDetails))
        val refreshCookie = CookieProvider.createCookie(CookieProvider.CookieName.REFRESH_TOKEN, refreshToken, TimeUnit.DAYS.toSeconds(jwtManager.refreshTokenExpireDay))
//        response.addCookie(refreshCookie) // => SameSite 속성과 호환이 되지 않으므로, 아래의 방법('Set-Cookie')을 사용한다.
        response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString())

        val jsonResult = objectMapper.writeValueAsString(CmResDto(HttpStatus.OK, "login success", principalDetails.member))
        responseData(response, jsonResult)
    }
}