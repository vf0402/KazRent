package com.example.kazRent.controller

import com.example.kazRent.model.CategoryProduct
import com.example.kazRent.model.Product
import com.example.kazRent.model.request.ProductRequest
import com.example.kazRent.repository.CategoryProductRepository
import com.example.kazRent.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = ["*"])
class ProductController(
    private var productRepository: ProductRepository,
    private var categoryProductRepository: CategoryProductRepository
) {
    @PostMapping("/add")
    fun createProduct(@RequestBody request: ProductRequest): ResponseEntity<Product> {
        return try {
            val categoryProduct = categoryProductRepository.findById(request.categoryProduct.id)
                .orElseThrow { IllegalArgumentException("Category product not found") }

            val product = Product(
                quantity = request.quantity,
                productName = request.productName,
                imgUrl = request.imgUrl,
                price = request.price,
                description = request.description,
                categoryProduct = categoryProduct
            )
            val newProduct = productRepository.save(product)
            ResponseEntity(newProduct, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable productId: Long): ResponseEntity<Void> {
        return try {
            if (productRepository.existsById(productId)) {
                productRepository.deleteById(productId)
                ResponseEntity(HttpStatus.OK)
            } else {
                ResponseEntity(HttpStatus.NOT_FOUND)
            }
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        val products = productRepository.findAll()
        return ResponseEntity.ok(products)
    }

}
