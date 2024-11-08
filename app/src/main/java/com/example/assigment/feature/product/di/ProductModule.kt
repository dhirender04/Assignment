package com.example.assigment.feature.product.di

import com.example.assigment.database.AppDatabase
import com.example.assigment.feature.product.data.api.ProductApiService
import com.example.assigment.feature.product.data.database.ProductDao
import com.example.assigment.feature.product.data.repository_impl.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object ProductModule {
    @Provides
    fun provideProductApiService(retrofit: Retrofit): ProductApiService = retrofit.create(ProductApiService::class.java)

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao = database.productDao()

    @Provides
    fun provideProductRepository(productApiService: ProductApiService,productDao: ProductDao): ProductRepositoryImpl = ProductRepositoryImpl(productApiService,productDao)
}