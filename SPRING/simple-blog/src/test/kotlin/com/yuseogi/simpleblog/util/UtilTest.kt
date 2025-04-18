package com.yuseogi.simpleblog.util

import com.yuseogi.simpleblog.config.security.JwtManager
import com.yuseogi.simpleblog.config.security.PrincipalDetails
import com.yuseogi.simpleblog.domain.member.Member
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UtilTest {

    private val log = KotlinLogging.logger {  }

    @Test
    fun errorLogTest() {
        log.error { "error!!" }
    }

    @Test
    fun bcryptEncodeTest() {
        val encoder = BCryptPasswordEncoder()

        val password = "1234"
        val encryptedPassword = encoder.encode(password)

        log.info { "encryptedPassword $encryptedPassword" }

        Assertions.assertThat(encoder.matches(password, encryptedPassword)).isTrue()
    }

    @Test
    fun generateJwtTest() {
        val jwtManager = JwtManager()

        val details = PrincipalDetails(Member.createFakeMember(1))
        val accessToken = jwtManager.generateAccessToken(details)

        val email = jwtManager.getMemberEmail(accessToken)

        log.info { "accessToken $accessToken" }
        log.info { "email $email" }
    }
}