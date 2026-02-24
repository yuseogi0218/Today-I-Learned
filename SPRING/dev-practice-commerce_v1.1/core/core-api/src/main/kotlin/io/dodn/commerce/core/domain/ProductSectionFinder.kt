package io.dodn.commerce.core.domain

import io.dodn.commerce.storage.db.core.ProductSectionRepository
import org.springframework.stereotype.Component

@Component
class ProductSectionFinder(
    private val productSectionRepository: ProductSectionRepository,
) {

    fun findSections(productId: Long): List<ProductSection> {
        return productSectionRepository.findByProductId(productId)
            .filter { it.isActive() }
            .map { ProductSection(it.type, it.content) }
    }

}