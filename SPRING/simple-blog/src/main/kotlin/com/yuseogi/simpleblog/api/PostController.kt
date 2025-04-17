package com.yuseogi.simpleblog.api

import com.yuseogi.simpleblog.domain.post.PostSaveReq
import com.yuseogi.simpleblog.service.PostService
import com.yuseogi.simpleblog.util.value.CmResDto
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
    private val postService: PostService
) {

    @PostMapping("/post")
    fun save(@Valid @RequestBody dto: PostSaveReq): CmResDto<*>{
        return CmResDto(HttpStatus.OK, "save Post", postService.save(dto))
    }

    @GetMapping("/posts")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable): CmResDto<*> {
        return CmResDto(HttpStatus.OK, "find All Posts", postService.findAll(pageable))
    }

    @GetMapping("/post/{id}")
    fun findById(@PathVariable id: Long): CmResDto<Any> {
        return CmResDto(HttpStatus.OK, "find Post by id", postService.findById(id))
    }

    @DeleteMapping("/post/{id}")
    fun deleteById(@PathVariable id: Long): CmResDto<Any> {
        return CmResDto(HttpStatus.OK, "delete Post by id", postService.delete(id))
    }
}