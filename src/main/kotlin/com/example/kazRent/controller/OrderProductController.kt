package com.example.kazRent.controller

import com.example.kazRent.model.OrderProduct
import com.example.kazRent.repository.OrderProductRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orderProduct")
@CrossOrigin(origins = ["*"])
class OrderProductController(
    private val orderProductRepository: OrderProductRepository
) {
    @GetMapping
    fun getAllProducts(): ResponseEntity<MutableList<OrderProduct>> {
        val orderProduct = orderProductRepository.findAll()
        return ResponseEntity.ok(orderProduct)
    }
}