package com.yuseogi.simpleblog.api

import com.yuseogi.simpleblog.domain.member.Member
import com.yuseogi.simpleblog.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService
) {

    @GetMapping("/members")
    fun findAll(): MutableList<Member> = memberService.findAll()
}