package com.example.assigment.feature.home.di

import com.example.assigment.database.AppDatabase
import com.example.assigment.feature.home.data.api.HomeApiService
import com.example.assigment.feature.home.data.database.BrandDao
import com.example.assigment.feature.home.data.database.CategoryDao
import com.example.assigment.feature.home.data.database.GroceryItemDao
import com.example.assigment.feature.home.data.database.SliderDao
import com.example.assigment.feature.home.data.repository_impl.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun providesApiService(retrofit: Retrofit): HomeApiService =
        retrofit.create(HomeApiService::class.java)

    @Provides
    fun provideBannerDao(database: AppDatabase): BrandDao = database.brandDao()

    @Provides
    fun provideSliderDao(database: AppDatabase): SliderDao = database.sliderDao()

    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao = database.categoryDao()

    @Provides
    fun provideGroceryDao(database: AppDatabase): GroceryItemDao = database.groceryItemDao()

    @Provides
    fun provideHomeRepository(
        apiService: HomeApiService,
        brandDao: BrandDao,
        sliderDao: SliderDao,
        categoryDao: CategoryDao,
        groceryItemDao: GroceryItemDao
    ): HomeRepositoryImpl = HomeRepositoryImpl(apiService, brandDao,sliderDao,categoryDao,groceryItemDao)

}