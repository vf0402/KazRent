package com.example.kazRent.controller

import com.example.kazRent.model.CategoryProduct
import com.example.kazRent.model.Product
import com.example.kazRent.repository.CategoryProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = ["*"])
class CategoryProductController(
    private val categoryProductRepository: CategoryProductRepository
) {
    @PostMapping("/add")
    fun createCategory(@RequestBody category: CategoryProduct): ResponseEntity<CategoryProduct> {
        return try {
            val newCategory = categoryProductRepository.save(category)
            ResponseEntity(newCategory, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping
    fun getAllProducts(): ResponseEntity<MutableList<CategoryProduct>> {
        val products = categoryProductRepository.findAll()
        return ResponseEntity.ok(products)
    }
}
