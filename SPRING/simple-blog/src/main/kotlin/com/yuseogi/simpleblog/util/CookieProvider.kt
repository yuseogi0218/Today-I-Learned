package com.yuseogi.simpleblog.util

import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseCookie
import java.util.*

// singleton 으로 관리됨 (?)
object CookieProvider {

    private val log = KotlinLogging.logger {  }

    // 정적 메서드 생성
    fun createNullCookie(name: String): String {
        TODO()
    }

    fun createCookie(cookieName: CookieName, value: String, maxAge: Long): ResponseCookie {
        return ResponseCookie
            .from(cookieName.name, value)
            .httpOnly(true)  // Client Javascript 에서 접근할 수 없도록
            .secure(false)  // 아직 HTTPS 를 적용하지 않았기 때문에 -> false
            .path("/")
            .maxAge(maxAge)  // 초 단위
            .build()
    }

    fun getCookie(request: HttpServletRequest, cookieName: CookieName): Optional<String> {
        val value = request.cookies.filter { cookie ->
            cookie.name == cookieName.name
        }.map { cookie ->
            cookie.value
        }.firstOrNull()

        log.debug { "cookie value => $value" }

        return Optional.ofNullable(value)
    }

    enum class CookieName{
        REFRESH_TOKEN
    }
}