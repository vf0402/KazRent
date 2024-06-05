package com.example.kazRent.model
import jakarta.persistence.*


@Entity
@Table(name = "t_categories")
data class CategoryProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "category_name", nullable = false)
    val categoryName: String
)
