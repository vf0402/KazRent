package com.example.kazRent.service

import com.example.kazRent.exception.CustomerNotFoundException
import com.example.kazRent.model.Customer
import com.example.kazRent.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun getById(userId: Long): Customer {
        return customerRepository.findById(userId).orElseThrow { CustomerNotFoundException() }
    }
}