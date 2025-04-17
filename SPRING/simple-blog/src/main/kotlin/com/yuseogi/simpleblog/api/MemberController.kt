package com.yuseogi.simpleblog.api

import com.yuseogi.simpleblog.domain.member.MemberSaveReq
import com.yuseogi.simpleblog.service.MemberService
import com.yuseogi.simpleblog.util.value.CmResDto
import jakarta.servlet.http.HttpSession
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/member")
    fun save(@Valid @RequestBody dto: MemberSaveReq): CmResDto<*>{
        return CmResDto(HttpStatus.OK, "save Member", memberService.save(dto))
    }

    @GetMapping("/members")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable): CmResDto<*> {
        return CmResDto(HttpStatus.OK, "find All Members", memberService.findAll(pageable))
    }

    @GetMapping("/member/{id}")
    fun findById(@PathVariable id: Long): CmResDto<Any> {
        return CmResDto(HttpStatus.OK, "find Member by id", memberService.findById(id))
    }

    @DeleteMapping("/member/{id}")
    fun deleteById(@PathVariable id: Long): CmResDto<Any> {
        return CmResDto(HttpStatus.OK, "delete Member by id", memberService.delete(id))
    }

}