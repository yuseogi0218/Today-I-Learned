package io.dodn.commerce.storage.db.core

import io.dodn.commerce.core.enums.ProductSectionType
import jakarta.persistence.Entity
import jakarta.persistence.Table

// Product 에 대한 상세 정보
@Entity
@Table(name = "product_section")
class ProductSectionEntity(
    val productId: Long,
    val type: ProductSectionType, // IMAGE, HTML
    val content: String, // IMAGE 일 경우 -> URL, HTML 일 경우 -> HTML 원본
) : BaseEntity()
