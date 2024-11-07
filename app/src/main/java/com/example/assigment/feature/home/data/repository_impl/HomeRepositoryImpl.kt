package com.example.assigment.feature.home.data.repository_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.assigment.feature.home.data.api.HomeApiService
import com.example.assigment.feature.home.data.database.BrandDao
import com.example.assigment.feature.home.data.database.CategoryDao
import com.example.assigment.feature.home.data.database.GroceryItemDao
import com.example.assigment.feature.home.data.database.SliderDao
import com.example.assigment.feature.home.data.model.dto.Category
import com.example.assigment.feature.home.data.model.dto.GroceryItemDto
import com.example.assigment.feature.home.data.model.dto.Slider
import com.example.assigment.feature.home.domain.mapper.toBrand
import com.example.assigment.feature.home.domain.mapper.toBrandEntity
import com.example.assigment.feature.home.domain.mapper.toCategory
import com.example.assigment.feature.home.domain.mapper.toCategoryEntity
import com.example.assigment.feature.home.domain.mapper.toGrocery
import com.example.assigment.feature.home.domain.mapper.toGroceryItemEntity
import com.example.assigment.feature.home.domain.mapper.toSlider
import com.example.assigment.feature.home.domain.mapper.toSliderEntity
import com.example.assigment.feature.home.domain.model.Brand

class HomeRepositoryImpl(
    private val apiService: HomeApiService,
    private val brandDao: BrandDao,
    private val sliderDao:SliderDao,
    private val categoryDao:CategoryDao,
    private val groceryDao:GroceryItemDao
) {

    suspend fun updateHomeData() {
        val response = apiService.getHomeData()
        brandDao.insertAll(response.topBrandArray.map { it.toBrandEntity() })

        sliderDao.insertAll(response.sliderArray.map { it.toSliderEntity() })
        categoryDao.insertAll(response.topCategoryArray.map { it.toCategoryEntity() })
        groceryDao.insertAll(response.groceryItemsArray.map { it.toGroceryItemEntity() })

    }

    fun getBrandData(): LiveData<List<Brand>> {
        return brandDao.getAllBrands().map {
            it.map { item -> item.toBrand() }
        }
    }
    fun getSliderData(): LiveData<List<Slider>>{
        return sliderDao.getAllSliders().map {
            it.map { item -> item.toSlider() }
        }
    }
    fun getCategoryData():LiveData<List<Category>>{
        return categoryDao.getAllCategories().map {
            it.map { item->item.toCategory() }
        }
    }
    fun getGroceryData():LiveData<List<GroceryItemDto>>{
        return groceryDao.getAllGroceryItems().map {
            it.map { item->item.toGrocery() }
        }
    }

}