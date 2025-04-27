package com.yuseogi.simpleblog.api

import com.yuseogi.simpleblog.domain.member.MemberDto
import com.yuseogi.simpleblog.service.AuthService
import com.yuseogi.simpleblog.util.value.CmResDto
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpSession
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class AuthController(
    private val authService: AuthService
) {

    val log = KotlinLogging.logger {  }

    @GetMapping("/login")
    fun login(session: HttpSession) {

        session.setAttribute("principal", "pass")
    }

    /**
     * 회원가입
     */
    @PostMapping("/member")
    fun signUp(@Valid @RequestBody dto: MemberDto): CmResDto<*> {
        return CmResDto(HttpStatus.OK, "회원가입", authService.save(dto))
    }

}