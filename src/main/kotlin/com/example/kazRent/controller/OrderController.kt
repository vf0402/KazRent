package com.example.kazRent.controller

import com.example.kazRent.model.Order
import com.example.kazRent.model.request.CreateOrderRequest
import com.example.kazRent.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = ["*"])
class OrderController(private val orderService: OrderService) {

    @PostMapping("/add/{customerId}")
    fun createOrder(
        @PathVariable customerId: Long,
        @RequestBody request: CreateOrderRequest
    ): ResponseEntity<Unit> {
        val order = orderService.createOrder(customerId, request.products, request.orderDate)
        return ResponseEntity.ok(order)
    }



    @GetMapping("/{customerId}")
    fun getOrdersByCustomerId(@PathVariable customerId: Long): ResponseEntity<List<Order>> {
        val orders = orderService.getOrdersByCustomerId(customerId)
        return ResponseEntity.ok(orders)
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrderById(@PathVariable orderId: Long): ResponseEntity<Void> {
        return try {
            orderService.deleteOrderById(orderId)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
