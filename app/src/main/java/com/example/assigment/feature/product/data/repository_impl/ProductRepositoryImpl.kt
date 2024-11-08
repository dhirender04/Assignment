package com.example.assigment.feature.product.data.repository_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.assigment.feature.home.domain.mapper.toBrandEntity
import com.example.assigment.feature.product.data.api.ProductApiService
import com.example.assigment.feature.product.data.database.ProductDao
import com.example.assigment.feature.product.domain.mapper.toProduct
import com.example.assigment.feature.product.domain.mapper.toProductEntity
import com.example.assigment.feature.product.domain.mapper.toProductList
import com.example.assigment.feature.product.domain.model.Product

class ProductRepositoryImpl(
    private val productApiService: ProductApiService,
    private val productDao: ProductDao
) {
    suspend fun updateProductData() {
        val response = productApiService.getMaintenanceData()
        productDao.insertProducts(response.map { it.toProductEntity() })

    }

        fun getProductData() = productDao.getAllProducts().map {
            it.toProductList()
        }





}