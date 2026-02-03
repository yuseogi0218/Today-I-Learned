package io.dodn.commerce.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "product_category")
class ProductCategoryEntity(
    val productId: Long,
    val categoryId: Long,
) : BaseEntity()
