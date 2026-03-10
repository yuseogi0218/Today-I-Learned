package io.dodn.commerce.core.domain

import java.math.BigDecimal

data class ReviewContent(
    val rate: BigDecimal,
    val content: String, // Review 작성 시, 내용에 대한 유효성 (Ex. 필수 여부, 길이 제한, 특수 문자, ...)
)
