package com.yuseogi.simpleblog.domain.member

data class MemberSaveReq (
    val email: String,
    val password: String,
    var role: Role
)

fun MemberSaveReq.toEntity(): Member {
    return Member(
        email = this.email,
        password = this.password,
        role = this.role
    )
}