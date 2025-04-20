package com.yuseogi.simpleblog.config.security

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.interfaces.DecodedJWT
import com.yuseogi.simpleblog.util.CookieProvider
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpServletRequest
import java.util.*
import java.util.concurrent.TimeUnit

class JwtManager(
    accessTokenExpireSecond: Long = 30, // 30초
    refreshTokenExpireDay: Long = 7 // 7일
) {

    private val log = KotlinLogging.logger {  }

    private val jwtSubject = "my-token"
    private val accessTokenExpireSecond: Long = accessTokenExpireSecond
    val refreshTokenExpireDay: Long = refreshTokenExpireDay
    private val accessSecretKey: String = "my-access-secret-key"
    private val refreshSecretKey: String = "my-refresh-secret-key"
    val authorizationHeader: String = "Authorization"
    val claimPrincipal = "principal"
    val jwtHeader: String = "Bearer "

    private fun generateJWT(expireDate: Date, principal: String, secretKey: String): String {
        return JWT.create()
            .withSubject(jwtSubject)
            .withExpiresAt(expireDate)
            .withClaim(claimPrincipal, principal)
            .sign(Algorithm.HMAC256(secretKey))
    }

    fun generateAccessToken(principal: String): String {
        val expireDate = Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(accessTokenExpireSecond))
        log.debug { "accessToken ExpiredDate=>$expireDate" }

        return generateJWT(expireDate, principal, accessSecretKey)
    }

    fun generateRefreshToken(principal: String): String {
        val expireDate = Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(refreshTokenExpireDay))
        log.debug { "refreshToken ExpiredDate=>$expireDate" }

        return generateJWT(expireDate, principal, refreshSecretKey)
    }

    fun getPrincipalByAccessToken(accessToken: String): String {
        val decodedJWT = getDecodedJWT(secretKey = accessSecretKey, token = accessToken)

        return decodedJWT.getClaim(claimPrincipal).asString()
    }

    fun getPrincipalByRefreshToken(refreshToken: String): String {
        val decodedJWT = getDecodedJWT(secretKey = refreshSecretKey, token = refreshToken)

        return decodedJWT.getClaim(claimPrincipal).asString()
    }

    private fun getDecodedJWT(secretKey: String, token: String): DecodedJWT {
        val verifier: JWTVerifier = JWT.require(Algorithm.HMAC256(secretKey))
            .build()
        return verifier.verify(token)
    }

    fun validateAccessToken(token: String): TokenValidResult {
        return validateJWT(accessSecretKey, token)
    }

    fun validateRefreshToken(token: String): TokenValidResult {
        return validateJWT(refreshSecretKey, token)
    }

    private fun validateJWT(secretKey: String, token: String): TokenValidResult { // TRUE | JWTVerificationException
        try {
            getDecodedJWT(secretKey, token)
            return TokenValidResult.Success()
        } catch (e: JWTVerificationException) {
            return TokenValidResult.Failure(e)
        }
    }

    fun reissueAccessToken(request: HttpServletRequest): String {
        log.debug { "Access Token 재발급" }
        // Cookie 에 있는 refreshToken 을 꺼내어서, accessToken 을 재발급 함
        val refreshToken = CookieProvider.getCookie(request, CookieProvider.CookieName.REFRESH_TOKEN).orElseThrow()
        val refreshTokenValidResult: TokenValidResult = validateRefreshToken(refreshToken)

        if (refreshTokenValidResult is TokenValidResult.Failure) {
            // logout 처리
            throw RuntimeException("invalid refreshToken")
        }

        return getPrincipalByRefreshToken(refreshToken)
    }

}

/**
 * Kotlin 으로 Union Type 같이 흉내
 */
sealed class TokenValidResult {

    class Success(val successValue: Boolean = true) : TokenValidResult()
    class Failure(val exception: JWTVerificationException) : TokenValidResult()

}