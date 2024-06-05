package com.example.kazRent.model.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductInput(
    @JsonProperty("productId") val productId: Long,
    @JsonProperty("sizeId") val sizeId: Long,
    @JsonProperty("quantity") val quantity: Int
)