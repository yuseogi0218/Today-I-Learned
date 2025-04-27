package com.yuseogi.simpleblog.domain.member

import com.yuseogi.simpleblog.config.BeanAccessor
import jakarta.validation.constraints.NotNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime

data class MemberDto(

    @field:NotNull(message = "require email")
    val email: String?,

    val rawPassword: String?,

    var role: Role?
) {

    fun toEntity(): Member {
        return Member(
            email = this.email ?: "",
            password = encodeRawPassword() ?: "",
            role = this.role ?: Role.USER
        )
    }

    private fun encodeRawPassword(): String? = BeanAccessor.getBean(PasswordEncoder::class).encode(this.rawPassword!!)
}

data class MemberRes(
    val id: Long,
    val email: String,
    val password: String,
    var role: Role,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)