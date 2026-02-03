package io.dodn.commerce.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "product")
class ProductEntity(
    val name: String,
    val thumbnailUrl: String,
    val description: String,
    val shortDescription: String,
    val costPrice: BigDecimal,
    val salesPrice: BigDecimal,
    val discountedPrice: BigDecimal,
) : BaseEntity()
