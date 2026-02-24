package io.dodn.commerce.core.domain

import io.dodn.commerce.core.enums.EntityStatus
import io.dodn.commerce.core.support.Page
import io.dodn.commerce.core.support.error.CoreException
import io.dodn.commerce.core.support.error.ErrorType
import io.dodn.commerce.storage.db.core.ProductCategoryRepository
import io.dodn.commerce.storage.db.core.ProductRepository
import io.dodn.commerce.storage.db.core.ProductSectionRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductFinder(
    private val productRepository: ProductRepository,
    private val productCategoryRepository: ProductCategoryRepository,
) {
    fun findByCategory(categoryId: Long, pageable: Pageable): Page<Product> {
        // 활성화된 productCategory 목록 조회
        val productCategories = productCategoryRepository.findByCategoryIdAndStatus(categoryId, EntityStatus.ACTIVE, pageable)
        // product 목록 조회는 상위에서 조회한 productCategory 목록을 기반으로 product 목록을 조회한다.

        // 비즈니스 로직 Option 1 : product 는 해당하는 productCategory 가 모두 삭제되어야지, 삭제(status -> DELETE) 할 수 있다.
        // 비즈니스 로직 Option 2 : product 삭제 시, 해당하는 productCategory 를 모두 먼저 삭제되어야 한다.
        // Audit Log 고려 필요 : productCategory 삭제 시, 언제 누구에 의해서 삭제되었는지 로그를 남겨야한다.
            // Ex. Option 2 활용 시에도 product 를 삭제한 사용자가 productCategory 를 삭제한 사용자가 된다.
        val products = productRepository.findAllById(productCategories.content.map { it.productId })
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
        return Page(products, productCategories.hasNext())
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

}
