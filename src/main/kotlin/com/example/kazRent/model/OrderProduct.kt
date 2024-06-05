package com.example.kazRent.model

import jakarta.persistence.*

@Entity
@Table(name = "t_order_products")
data class OrderProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id", nullable = false)
    val size: Size,

    @Column(name = "quantity", nullable = false)
    val quantity: Int
)
