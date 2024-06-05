package com.example.kazRent.service

import com.example.kazRent.model.Order
import com.example.kazRent.model.OrderProduct
import com.example.kazRent.model.Product
import com.example.kazRent.model.Size
import com.example.kazRent.model.request.OrderProductRequest
import com.example.kazRent.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository,
    private val productRepository: ProductRepository,
    private val sizeRepository: SizeRepository
) {

    @Transactional
    fun createOrder(customerId: Long, orderDetails: List<OrderProductRequest>, orderDate: LocalDate) {
        val customer = customerRepository.findById(customerId)
            .orElseThrow { IllegalArgumentException("Customer not found") }

        if (orderDate.isAfter(LocalDate.now().plusWeeks(3))) {
            throw IllegalArgumentException("Order date cannot be more than 3 weeks in the future.")
        }

        val order = Order(
            customer = customer,
            orderDate = orderDate,
            orderStatus = "NEW"
        )

        val savedOrder = orderRepository.save(order)

        orderDetails.forEach { orderDetail ->
            val product = productRepository.findById(orderDetail.productId)
                .orElseThrow { IllegalArgumentException("Product not found") }

            val size = sizeRepository.findById(orderDetail.sizeId)
                .orElseThrow { IllegalArgumentException("Size not found") }

            if (orderDetail.quantity > product.quantity) {
                throw IllegalArgumentException("Not enough available quantity for product ${product.productName}")
            }

            val orderProduct = OrderProduct(
                order = savedOrder,
                product = product,
                size = size,
                quantity = orderDetail.quantity
            )
            savedOrder.orderProducts += orderProduct
        }
    }
        fun getOrdersByCustomerId(customerId: Long): List<Order> {
            return orderRepository.findByCustomerId(customerId)
        }

        @Transactional
        fun deleteOrderById(orderId: Long) {
            if (orderRepository.existsById(orderId)) {
                orderRepository.deleteById(orderId)
            } else {
                throw IllegalArgumentException("Order not found")
            }
        }
    }

