package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.PointType
import io.dodn.commerce.core.support.OffsetLimit
import io.dodn.commerce.core.support.Page
import org.springframework.stereotype.Service

@Service
class ReviewService(
    private val reviewFinder: ReviewFinder,
    private val reviewManager: ReviewManager,
    private val reviewPolicyValidator: ReviewPolicyValidator,
    private val pointHandler: PointHandler,
) {
    fun findRateSummary(target: ReviewTarget): RateSummary {
        return reviewFinder.findRateSummary(target)
    }

    fun findReviews(target: ReviewTarget, offsetLimit: OffsetLimit): Page<Review> {
        return reviewFinder.find(target, offsetLimit)
    }

    fun addReview(user: User, target: ReviewTarget, content: ReviewContent): Long {
        val reviewKey = reviewPolicyValidator.validateNew(user, target)
        val reviewId = reviewManager.add(reviewKey, target, content)
        // 포인트 정책 : Review 작성 시, 포인트 지급
        pointHandler.earn(user, PointType.REVIEW, reviewId, PointAmount.REVIEW)
        return reviewId
    }

    fun updateReview(user: User, reviewId: Long, content: ReviewContent): Long {
        reviewPolicyValidator.validateUpdate(user, reviewId)
        return reviewManager.update(user, reviewId, content)
    }

    fun removeReview(user: User, reviewId: Long): Long {
        val deletedReviewId = reviewManager.delete(user, reviewId)
        // 포인트 정책 : Review 삭제 시, 포인트 차감
        pointHandler.deduct(user, PointType.REVIEW, deletedReviewId, PointAmount.REVIEW)
        return deletedReviewId
    }
}
