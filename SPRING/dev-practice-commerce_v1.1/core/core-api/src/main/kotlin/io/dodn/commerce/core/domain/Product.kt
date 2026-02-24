package io.dodn.commerce.core.domain

data class Product(
    val id: Long,
    val name: String,
    val thumbnailUrl: String,
    val description: String,
    val shortDescription: String,
    // Product 와 Price 는 별도의 개념으로 인지하여, Price 를 별도의 개념으로 분리하여 관리
    // Ex. 추후 Price 개념에 계산 로직이 추가될 경우, 해당 클래스에서 이를 다룰 수 있도록 한다.
    val price: Price,
)
