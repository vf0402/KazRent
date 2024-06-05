package com.example.kazRent.repository

import com.example.kazRent.model.CategoryProduct
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryProductRepository : JpaRepository<CategoryProduct, Long>
