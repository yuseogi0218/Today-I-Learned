package io.dodn.commerce.core.api.controller.v1

import io.dodn.commerce.core.api.controller.v1.response.ProductDetailResponse
import io.dodn.commerce.core.api.controller.v1.response.ProductResponse
import io.dodn.commerce.core.domain.CouponService
import io.dodn.commerce.core.domain.ProductSectionService
import io.dodn.commerce.core.domain.ProductService
import io.dodn.commerce.core.domain.ReviewService
import io.dodn.commerce.core.domain.ReviewTarget
import io.dodn.commerce.core.enums.ReviewTargetType
import io.dodn.commerce.core.support.OffsetLimit
import io.dodn.commerce.core.support.response.ApiResponse
import io.dodn.commerce.core.support.response.PageResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    // 컨트롤러에서 각 개념에 대한 서비스를 개별로 주입받도록 하는 이유 -> 각 개념들이 서로를 모르게 하기 위해서. (격벽을 안넘을 수 있도록 하기 위해서)
    // Ex. Product 는 ProductSection, Review, Coupon 개념을 꼭 알 필요가 없다.
    private val productService: ProductService,
    private val productSectionService: ProductSectionService,
    private val reviewService: ReviewService,
    private val couponService: CouponService,
) {
    @GetMapping("/v1/products")
    fun findProducts(
        @RequestParam categoryId: Long,
        @RequestParam offset: Int,
        @RequestParam limit: Int,
    ): ApiResponse<PageResponse<ProductResponse>> {
        val result = productService.findProducts(categoryId, OffsetLimit(offset, limit))
        return ApiResponse.success(PageResponse(ProductResponse.of(result.content), result.hasNext))
    }

    @GetMapping("/v1/products/{productId}")
    fun findProduct(
        @PathVariable productId: Long,
    ): ApiResponse<ProductDetailResponse> {
        val product = productService.findProduct(productId)
        // Product 는 다양한 곳에서 사용될 수 있지만, ProductSection 은 상품 상세에서만 사용되는 정보이다.
        val sections = productSectionService.findSections(productId)
        val rateSummary = reviewService.findRateSummary(ReviewTarget(ReviewTargetType.PRODUCT, productId))
        // NOTE: 별도 API 가 나을까?
        // 조회 API 는 개념 단위별로 묶어주는게 재사용성에 좋다.
        // Ex. 상품 정보 API (상품 이미지, 이름, 설명, 가격, 상세 설명), 평점 & 리뷰 API, 관련 쿠폰 With 다운로드 링크 API, ...
        // But, 상황(요구사항, UI)에 맞춰서 선택할 수 있도록 (Trade-Off)
        // Ex. 쿠폰 정보가 모달 또는 팝업으로 나타난다면, API 를 분리하는게 좋을수도
        // Ex. 매번 요구사항이 바뀐다면, 이처럼 하나의 API 로 내려주는게 좋을수도
        val coupons = couponService.getCouponsForProducts(listOf(productId))
        return ApiResponse.success(ProductDetailResponse(product, sections, rateSummary, coupons))
    }
}
