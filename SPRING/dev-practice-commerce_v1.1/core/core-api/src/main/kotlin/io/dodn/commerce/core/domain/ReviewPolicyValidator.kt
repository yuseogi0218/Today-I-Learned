package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.EntityStatus
import io.dodn.commerce.core.enums.OrderState
import io.dodn.commerce.core.enums.ReviewTargetType
import io.dodn.commerce.core.support.error.CoreException
import io.dodn.commerce.core.support.error.ErrorType
import io.dodn.commerce.storage.db.core.OrderItemRepository
import io.dodn.commerce.storage.db.core.ReviewRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

/**
 * Review 에 관한 정책을 검증하는 소스코드를 한 곳에 모아둠.
 * - 해당 Component 에 대한 테스트 코드 작성 시, -> Review 에 관한 정책을 테스트할 수 있도록 모듈을 분리해둔것.
 */
@Component
class ReviewPolicyValidator(
    private val orderItemRepository: OrderItemRepository,
    private val reviewRepository: ReviewRepository,
) {
    fun validateNew(user: User, target: ReviewTarget): ReviewKey {
        if (target.type == ReviewTargetType.PRODUCT) {
            // 상세한 상품에 대한 리뷰 작성 규칙 정의가 필요하다.
            // Ex. 최소 14일간 구매한 상품에 대한 리뷰 작성 가능
            val reviewKeys = orderItemRepository.findRecentOrderItemsForProduct(user.id, target.id, OrderState.PAID, LocalDateTime.now().minusDays(14), EntityStatus.ACTIVE)
                .map { "ORDER_ITEM_${it.id}" }

            val existReviewKeys = reviewRepository.findByUserIdAndReviewKeyIn(user.id, reviewKeys).map { it.reviewKey }.toSet()

            // ReviewKey 발급 정책
            // - 최소 14일간 구매한 상품에 대한 리뷰 작성 가능
            // - 구매 내역에 대한 리뷰는 한번만 작성 가능
            return ReviewKey(
                user = user,
                key = reviewKeys.firstOrNull { it !in existReviewKeys } ?: throw CoreException(ErrorType.REVIEW_HAS_NOT_ORDER),
            )
        }
        throw UnsupportedOperationException()
    }

    fun validateUpdate(user: User, reviewId: Long) {
        val review = reviewRepository.findByIdAndUserId(reviewId, user.id) ?: throw CoreException(ErrorType.NOT_FOUND_DATA)
        // Review 수정 정책
        // - 리뷰 작성 후 7일 이내에만 수정 가능
        if (review.createdAt.plusDays(7).isBefore(LocalDateTime.now())) throw CoreException(ErrorType.REVIEW_UPDATE_EXPIRED)
    }
}
