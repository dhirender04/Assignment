package com.example.assigment.feature.product.data.api

 import com.example.assigment.feature.product.data.model.dto.ProductDto
 import retrofit2.http.GET

interface ProductApiService {
    @GET("maintenance.php")
    suspend fun getMaintenanceData():List<ProductDto>

}