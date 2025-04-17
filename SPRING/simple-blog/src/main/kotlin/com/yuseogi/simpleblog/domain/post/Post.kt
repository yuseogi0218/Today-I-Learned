package com.yuseogi.simpleblog.domain.post

import com.yuseogi.simpleblog.domain.AuditingEntity
import com.yuseogi.simpleblog.domain.member.Member
import com.yuseogi.simpleblog.domain.member.toDto
import jakarta.persistence.*

@Entity
@Table(name = "Post")
class Post(
    title: String,
    content: String,
    member: Member

) : AuditingEntity() {

    @Column(name = "title", nullable = false)
    var title:String = title
        protected set

    @Column(name = "content")
    var content:String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Member::class)
    var member:Member = member
        protected set

    override fun toString(): String {
        return "Post(id='$id', title='$title', content='$content', member=$member)"
    }


}

fun Post.toDto(): PostRes {
    return PostRes(
        id = this.id!!,
        title = this.title,
        content = this.content,
        member = this.member.toDto()
    )
}