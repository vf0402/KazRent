package com.example.kazRent.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "t_orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @Column(name = "order_date", nullable = false)
    val orderDate: LocalDate,

    @Column(name = "order_status", nullable = false)
    val orderStatus: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    var orderProducts: List<OrderProduct> = mutableListOf()
)