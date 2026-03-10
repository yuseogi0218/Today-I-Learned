package io.dodn.commerce.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "answer")
class AnswerEntity(
    // 관리자만 질문에 대한 답변 작성이 가능하다.
    val adminId: Long,
    // 답변은 질문에 대해서만 작성이 가능하다.
    val questionId: Long,
    val content: String,
) : BaseEntity()
