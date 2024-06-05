package com.example.kazRent.repository

import com.example.kazRent.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository : JpaRepository<Order, Long> {
    @Query("SELECT * FROM t_orders WHERE customer_id = :customerId", nativeQuery = true)
    fun findByCustomerId(customerId: Long): List<Order>

//    @Query("SELECT o FROM Order o JOIN FETCH o.orderProducts")
//    fun findAllWithOrderProducts(): List<Order>
}
