package com.yuseogi.simpleblog.domain.member

import com.yuseogi.simpleblog.domain.AuditingEntity
import jakarta.persistence.*

@Entity
@Table(name = "Member")
class Member(
    id: Long = 0,
    email: String,
    password: String,
    role: Role = Role.USER

) : AuditingEntity(id) {

    @Column(name = "email")
    var email: String = email
        protected set

    @Column(name = "password")
    var password: String = password
        protected set

    @Enumerated(value = EnumType.STRING)
    var role: Role = role
        protected set

    override fun toString(): String {
        return "Member(id='$id', email='$email', password='$password', role=$role, createdAt=$createdAt)"
    }

    fun toDto(): MemberRes {
        return MemberRes(
            id = this.id!!,
            email = this.email,
            password = this.password,
            role = this.role,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }

    companion object {
        fun createFakeMember(memberId: Long): Member {
            val member = Member(memberId, "admin@gmail.com", "1234")
            member.id = memberId
            return member
        }
    }

}

enum class Role {
    USER, ADMIN
}