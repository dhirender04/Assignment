package com.example.assigment.feature.product.domain.model



data class Product(
    val id: String,
    val name: String,
    val arraydata: List<ProductListItem>
)

data class ProductListItem(
    val val_id: String,
    val name: String,
    val image: String,
    val price:String
)