package com.yuseogi.simpleblog.service

import com.yuseogi.simpleblog.config.security.PrincipalDetails
import com.yuseogi.simpleblog.domain.member.MemberDto
import com.yuseogi.simpleblog.domain.member.MemberRepository
import com.yuseogi.simpleblog.domain.member.MemberRes
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val memberRepository: MemberRepository
) : UserDetailsService {

    private val log = KotlinLogging.logger {  }

    override fun loadUserByUsername(email: String): UserDetails {
        val member = memberRepository.findMemberByEmail(email)

        return PrincipalDetails(member)
    }

    @Transactional
    fun save(dto: MemberDto): MemberRes {
        return memberRepository.save(dto.toEntity()).toDto()
    }

}