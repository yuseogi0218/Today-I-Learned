package com.yuseogi.simpleblog.domain.member

import com.yuseogi.simpleblog.domain.AuditingEntity
import jakarta.persistence.*

@Entity
@Table(name = "Member")
class Member(
    email: String,
    password: String,
    role: Role

) : AuditingEntity() {

    @Column(name = "email")
    var email: String = email
        protected set

    @Column(name = "password")
    var password: String = password
        protected set

    @Enumerated(value = EnumType.STRING)
    var role: Role = role
        protected set
}

enum class Role {
    USER, ADMIN
}