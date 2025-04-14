package com.yuseogi.simpleblog.service

import com.yuseogi.simpleblog.domain.member.Member
import com.yuseogi.simpleblog.domain.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService (
    private val memberRepository: MemberRepository

) {

    @Transactional(readOnly = false)
    fun findAll(): MutableList<Member> = memberRepository.findAll()


}