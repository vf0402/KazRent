package com.example.kazRent.model.request
import java.time.LocalDate

data class CreateOrderRequest(
    val products: List<OrderProductRequest>,
    val orderDate: LocalDate
)

