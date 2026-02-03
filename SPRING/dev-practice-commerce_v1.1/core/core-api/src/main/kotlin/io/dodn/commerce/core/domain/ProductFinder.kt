package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.EntityStatus
import io.dodn.commerce.core.support.OffsetLimit
import io.dodn.commerce.core.support.Page
import io.dodn.commerce.core.support.error.CoreException
import io.dodn.commerce.core.support.error.ErrorType
import io.dodn.commerce.storage.db.core.ProductCategoryRepository
import io.dodn.commerce.storage.db.core.ProductRepository
import io.dodn.commerce.storage.db.core.ProductSectionRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductFinder(
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository,
    private val productSectionRepository: ProductSectionRepository,
) {
    fun findByCategory(categoryId: Long, offsetLimit: OffsetLimit): Page<Product> {
        val categories = productCategoryRepository.findByCategoryIdAndStatus(categoryId, EntityStatus.ACTIVE, offsetLimit.toPageable())
        val products = productRepository.findAllById(categories.content.map { it.productId })
            .map {
                Product(
                    id = it.id,
                    name = it.name,
                    thumbnailUrl = it.thumbnailUrl,
                    description = it.description,
                    shortDescription = it.shortDescription,
                    price = Price(
                        costPrice = it.costPrice,
                        salesPrice = it.salesPrice,
                        discountedPrice = it.discountedPrice,
                    ),
                )
            }
        return Page(products, categories.hasNext())
    }

    fun find(productId: Long): Product {
        val found = productRepository.findByIdOrNull(productId)?.takeIf { it.isActive() }
            ?: throw CoreException(ErrorType.NOT_FOUND_DATA)

        return Product(
            id = found.id,
            name = found.name,
            thumbnailUrl = found.thumbnailUrl,
            description = found.description,
            shortDescription = found.shortDescription,
            price = Price(
                costPrice = found.costPrice,
                salesPrice = found.salesPrice,
                discountedPrice = found.discountedPrice,
            ),
        )
    }

    fun findSections(productId: Long): List<ProductSection> {
        return productSectionRepository.findByProductId(productId)
            .filter { it.isActive() }
            .map { ProductSection(it.type, it.content) }
    }
}
