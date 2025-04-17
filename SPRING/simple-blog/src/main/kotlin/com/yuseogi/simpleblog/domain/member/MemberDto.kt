package com.yuseogi.simpleblog.domain.member

import jakarta.validation.constraints.NotNull

data class MemberSaveReq(

    @field:NotNull(message = "require email")
    val email: String?,

    val password: String?,

    var role: Role?
)

fun MemberSaveReq.toEntity(): Member {
    return Member(
        email = this.email ?: "",
        password = this.password ?: "",
        role = this.role ?: Role.USER
    )
}

data class MemberRes(
    val id: Long,
    val email: String,
    val password: String,
    var role: Role
)