package com.example.kazRent.model.request

data class OrderProductRequest(
    val productId: Long,
    val sizeId: Long,
    val quantity: Int
)
