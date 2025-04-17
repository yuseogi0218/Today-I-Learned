package com.yuseogi.simpleblog.service

import com.yuseogi.simpleblog.domain.member.*
import com.yuseogi.simpleblog.exception.MemberNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun save(dto: MemberSaveReq): MemberRes {
        return memberRepository.save(dto.toEntity()).toDto()
    }

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<MemberRes> =
        memberRepository.findMembers(pageable).map {
            it.toDto()
        }

    @Transactional(readOnly = true)
    fun findById(id: Long): MemberRes {
        return memberRepository.findById(id).orElseThrow {
            throw MemberNotFoundException(id)
        }.toDto()
    }

    @Transactional
    fun delete(id: Long) {
        return memberRepository.deleteById(id)
    }

}