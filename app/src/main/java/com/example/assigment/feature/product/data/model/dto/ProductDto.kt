package com.example.assigment.feature.product.data.model.dto


import com.example.assigment.feature.product.data.model.entity.generateRandomPrice
import com.fasterxml.jackson.annotation.JsonProperty

data class ProductDto(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("arraydata") val arraydata: List<ProductListItemDto>
)

data class ProductListItemDto(
    @JsonProperty("_id") val val_id: String?=null,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String,
    @JsonProperty("price") var price: String?=null // Provide default value if needed
){

}