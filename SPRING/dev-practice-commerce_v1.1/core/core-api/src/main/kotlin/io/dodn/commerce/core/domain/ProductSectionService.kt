package io.dodn.commerce.core.domain

import org.springframework.stereotype.Service

@Service
class ProductSectionService(
    private val productSectionFinder: ProductSectionFinder,
) {
    fun findSections(productId: Long): List<ProductSection> {
        return productSectionFinder.findSections(productId)
    }
}
