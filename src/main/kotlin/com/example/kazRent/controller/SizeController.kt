package com.example.kazRent.controller
import com.example.kazRent.model.Product
import com.example.kazRent.model.Size
import com.example.kazRent.repository.SizeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/sizes")
@CrossOrigin(origins = ["*"])
class SizeController(
    private val sizeRepository:SizeRepository
) {
    @PostMapping("/add")
    fun createSize(@RequestBody size: Size): ResponseEntity<Size> {
        return try {
            val newSize = sizeRepository.save(size)
            ResponseEntity(newSize, HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @GetMapping
    fun getAllProducts(): ResponseEntity<MutableList<Size>> {
        val size = sizeRepository.findAll()
        return ResponseEntity.ok(size)
    }
}