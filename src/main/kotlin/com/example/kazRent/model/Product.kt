package com.example.kazRent.model

import jakarta.persistence.*

@Entity
@Table(name = "t_products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "product_name", nullable = false)
    val productName: String,

    @Column(name = "product_quantity", nullable = false)
    var quantity: Int,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "price", nullable = false)
    val price: Int,

    @Column(name = "imgUrl", nullable = false)
    val imgUrl: String,

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    var categoryProduct: CategoryProduct
)
