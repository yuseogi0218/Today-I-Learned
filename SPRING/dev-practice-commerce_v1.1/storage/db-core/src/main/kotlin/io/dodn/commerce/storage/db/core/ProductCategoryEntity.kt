package io.dodn.commerce.storage.db.core

import jakarta.persistence.Entity
import jakarta.persistence.Table

// product <-> category 는 M:N 매핑
// productCategory 는 product 와 category 를 모두 다 알고있다. (의존하고 있다.)
@Entity
@Table(name = "product_category")
class ProductCategoryEntity(
    // product 가 category 의 상위 개념
    val productId: Long, // product - 1급 개념
    val categoryId: Long, // category - 2급 개념
) : BaseEntity()
