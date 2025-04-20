package com.yuseogi.simpleblog.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.yuseogi.simpleblog.config.security.JwtManager
import com.yuseogi.simpleblog.config.security.PrincipalDetails
import com.yuseogi.simpleblog.domain.member.Member
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UtilTest {

    private val log = KotlinLogging.logger {  }

    val objectMapper = ObjectMapper()

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
        objectMapper.registerModules(JavaTimeModule())
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.registerModules(
            KotlinModule.Builder()
                .configure(KotlinFeature.StrictNullChecks, false)
                .configure(KotlinFeature.NullIsSameAsDefault, false)
                .configure(KotlinFeature.NullToEmptyMap, false)
                .configure(KotlinFeature.NullToEmptyCollection, false)
                .configure(KotlinFeature.SingletonSupport, false)
                .build()
        )

        val jwtManager = JwtManager(accessTokenExpireSecond = 1)

        val details = PrincipalDetails(Member.createFakeMember(1))
        val jsonPrincipal = objectMapper.writeValueAsString(details)
        val accessToken = jwtManager.generateAccessToken(jsonPrincipal)

        Thread.sleep(2 * 1000)

        val decodedJWT = jwtManager.validateAccessToken(accessToken)

        val principalString = decodedJWT.getClaim(jwtManager.claimPrincipal).asString()
        val principalDetails = objectMapper.readValue(principalString, PrincipalDetails::class.java)

        log.info { "result => ${principalDetails.member}" }
    }
}