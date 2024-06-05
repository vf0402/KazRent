package com.example.kazRent.controller

import com.example.kazRent.model.Customer
import com.example.kazRent.response.MessagedResponse
import com.example.kazRent.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = ["*"])
class CustomerController(
    private val customerService: CustomerService
) {
    @GetMapping("/{customerId}")
    fun getCustomerById(
        @PathVariable customerId: Long
    ): MessagedResponse<Customer> {
        return customerService.getById(customerId).let(MessagedResponse.Companion::of)
    }
}