package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.CouponTargetType
import io.dodn.commerce.core.enums.EntityStatus
import io.dodn.commerce.storage.db.core.CouponRepository
import io.dodn.commerce.storage.db.core.CouponTargetRepository
import io.dodn.commerce.storage.db.core.ProductCategoryRepository
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val couponTargetRepository: CouponTargetRepository,
    private val productCategoryRepository: ProductCategoryRepository,
) {
    fun getCouponsForProducts(productIds: Collection<Long>): List<Coupon> {
        // 쿠폰 타겟 조회
        val productTargets = couponTargetRepository.findByTargetTypeAndTargetIdInAndStatus(
            CouponTargetType.PRODUCT,
            productIds,
            EntityStatus.ACTIVE,
        )
        val categoryTargets = couponTargetRepository.findByTargetTypeAndTargetIdInAndStatus(
            CouponTargetType.PRODUCT_CATEGORY,
            productCategoryRepository.findByProductIdInAndStatus(productIds, EntityStatus.ACTIVE).map { it.categoryId },
            EntityStatus.ACTIVE,
        )
        // 사용자가 특정 상품에 대해서 실제 사용할 수 있는 쿠폰 목록 조회
        return couponRepository.findByIdInAndStatus((productTargets + categoryTargets).map { it.couponId }.toSet(), EntityStatus.ACTIVE)
            .map {
                Coupon(
                    id = it.id,
                    name = it.name,
                    type = it.type,
                    discount = it.discount,
                    expiredAt = it.expiredAt,
                )
            }
    }
}
