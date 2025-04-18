package com.yuseogi.simpleblog.config.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.github.oshai.kotlinlogging.KotlinLogging
import java.util.Date

class JwtManager {

    private val log = KotlinLogging.logger {  }

    private val expireTime = 60 * 60 * 1000
    private val claimEmail = "email"
    private val claimPassword = "password"
    private val secretKey: String = "secret-key"
    val jwtHeader: String = "Authorization"

    fun generateAccessToken(principal: PrincipalDetails): String {
        return JWT.create()
            .withSubject(principal.username)
            .withExpiresAt(Date(System.nanoTime() + expireTime))
            .withClaim(claimEmail, principal.username)
            .withClaim(claimPassword, principal.password)
            .sign(Algorithm.HMAC256(secretKey))
    }

    fun getMemberEmail(token: String): String? {
        return JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token)
            .getClaim(claimEmail).asString()
    }

}