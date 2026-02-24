package io.dodn.commerce.storage.db.core

import io.dodn.commerce.core.enums.ReviewTargetType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Index
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(
    name = "review",
    indexes = [
        Index(name = "udx_user_review", columnList = "userId, reviewKey", unique = true),
    ],
)
class ReviewEntity(
    val userId: Long,
    val reviewKey: String,
    @Enumerated(EnumType.STRING)
    val targetType: ReviewTargetType,
    val targetId: Long,
    rate: BigDecimal, // 리뷰의 점수 데이터 형태는 어떻게 구성할지? - Ex. 정수(1~5점), 소수 첫째자릿수 (0.0 ~ 5.0점 - 0.5 단위)
    content: String,
) : BaseEntity() {
    var rate: BigDecimal = rate
        protected set

    @Column(columnDefinition = "TEXT")
    var content: String = content
        protected set

    fun updateContent(rate: BigDecimal, content: String) {
        this.rate = rate
        this.content = content
    }
}
