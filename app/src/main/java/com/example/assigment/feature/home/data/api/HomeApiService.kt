package com.example.assigment.feature.home.data.api

import com.example.assigment.feature.home.data.model.dto.HomeResponse
import retrofit2.http.GET

interface HomeApiService {
    @GET("home.php")
    suspend fun getHomeData(): HomeResponse
}
