package com.example.kazRent.repository

import com.example.kazRent.model.OrderProduct
import com.example.kazRent.model.Product
import com.example.kazRent.model.Size
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface OrderProductRepository : JpaRepository<OrderProduct, Long> {
    fun findAllByProductAndSizeAndOrder_OrderDateBetween(
        product: Product,
        size: Size,
        startDate: LocalDate,
        endDate: LocalDate
    ): List<OrderProduct>
}
