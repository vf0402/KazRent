package com.example.kazRent.model.request

data class ProductRequest(
    val quantity: Int,
    val productName: String,
    val imgUrl: String,
    val price: Int,
    val description: String,
    val categoryProduct: CategoryProductRequest
)
