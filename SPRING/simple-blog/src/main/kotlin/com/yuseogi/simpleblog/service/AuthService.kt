package com.yuseogi.simpleblog.service

import com.yuseogi.simpleblog.config.security.PrincipalDetails
import com.yuseogi.simpleblog.domain.member.MemberRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val memberRepository: MemberRepository
) : UserDetailsService {

    private val log = KotlinLogging.logger {  }

    override fun loadUserByUsername(email: String): UserDetails {
        val member = memberRepository.findMemberByEmail(email)

        return PrincipalDetails(member)
    }

}