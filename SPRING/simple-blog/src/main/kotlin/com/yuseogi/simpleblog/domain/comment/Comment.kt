package com.yuseogi.simpleblog.domain.comment

import com.yuseogi.simpleblog.domain.AuditingEntity
import com.yuseogi.simpleblog.domain.post.Post
import jakarta.persistence.*

@Entity
@Table(name = "Comment")
class Comment(
    content: String,
    post: Post
) : AuditingEntity() {

    @Column(name = "content", nullable = false)
    var content: String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post: Post = post
        protected set
}