package com.example.kazRent.repository

import com.example.kazRent.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
