package com.yuseogi.simpleblog.service

import com.yuseogi.simpleblog.domain.post.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun save(dto: PostSaveReq): PostRes {
        return postRepository.save(dto.toEntity()).toDto()
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<PostRes> =
        postRepository.findPosts(pageable).map {
            it.toDto()
        }

    @Transactional(readOnly = true)
    fun findById(id: Long): PostRes {
        return postRepository.findById(id).orElseThrow().toDto()
    }

    @Transactional
    fun delete(id: Long) {
        return postRepository.deleteById(id)
    }

}