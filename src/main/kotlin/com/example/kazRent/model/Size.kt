package com.example.kazRent.model
import jakarta.persistence.*

@Entity
@Table(name = "t_sizes")
data class Size(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "size_name", nullable = false)
    val sizeName: String
)
