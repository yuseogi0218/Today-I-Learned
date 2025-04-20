package com.yuseogi.simpleblog.config.security

import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

class CustomBasicAuthenticationFilter(
    private val objectMapper: ObjectMapper,
    authenticationManager: AuthenticationManager
) : BasicAuthenticationFilter(authenticationManager) {

    private val log = KotlinLogging.logger {  }

    private val jwtManager = JwtManager()

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        log.info { "권한이나 인증이 필요한 요청이 들어옴" }

        val accessToken = request.getHeader(jwtManager.authorizationHeader)?.replace("Bearer ", "")

        if (accessToken == null) {
            chain.doFilter(request, response)
            return
        }

        val accessTokenValidResult: TokenValidResult = jwtManager.validateAccessToken(accessToken)

        if (accessTokenValidResult is TokenValidResult.Failure) {
            if (accessTokenValidResult.exception is TokenExpiredException) {
                val principalJsonData = jwtManager.reissueAccessToken(request)
                val principalDetails = objectMapper.readValue(principalJsonData, PrincipalDetails::class.java)

                val newAccessToken = jwtManager.generateAccessToken(principalJsonData)
                response.addHeader(jwtManager.authorizationHeader, jwtManager.jwtHeader + newAccessToken)

                val authentication: Authentication = UsernamePasswordAuthenticationToken(principalDetails, "", principalDetails.authorities)

                SecurityContextHolder.getContext().authentication = authentication
                chain.doFilter(request, response)

                return
            } else {
                log.error { accessTokenValidResult.exception.stackTrace }
            }
        }

        val principalJsonData = jwtManager.getPrincipalByAccessToken(accessToken)
        val principalDetails = objectMapper.readValue(principalJsonData, PrincipalDetails::class.java)

        // DB 호출 부
//        val member = memberRepository.findMemberByEmail(principal.member.email)
//        val principalDetails = PrincipalDetails(member)

        val authentication: Authentication = UsernamePasswordAuthenticationToken(principalDetails, "", principalDetails.authorities)

        SecurityContextHolder.getContext().authentication = authentication

        chain.doFilter(request, response)
    }
}