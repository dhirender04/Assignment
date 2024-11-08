package com.example.assigment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.assigment.feature.home.data.database.BrandDao
import com.example.assigment.feature.home.data.database.CategoryDao
import com.example.assigment.feature.home.data.database.GroceryItemDao
import com.example.assigment.feature.home.data.database.SliderDao
import com.example.assigment.feature.home.data.model.dto.Slider
import com.example.assigment.feature.home.data.model.entity.BrandEntity
import com.example.assigment.feature.home.data.model.entity.CategoryEntity
import com.example.assigment.feature.home.data.model.entity.GroceryItemEntity
import com.example.assigment.feature.home.data.model.entity.SliderEntity
import com.example.assigment.feature.product.data.database.ProductDao
import com.example.assigment.feature.product.data.model.entity.ProductEntity
import com.example.assigment.feature.product.data.model.entity.ProductListItemEntity
import com.example.assigment.feature.product.data.model.entity.ProductListItemListConverter

@Database(entities = [BrandEntity::class, CategoryEntity::class, GroceryItemEntity::class,SliderEntity::class,ProductEntity::class, ProductListItemEntity::class], version = 1,exportSchema = false)
@TypeConverters(ProductListItemListConverter::class)
abstract class AppDatabase : RoomDatabase() {
abstract fun sliderDao(): SliderDao
abstract fun categoryDao(): CategoryDao
abstract fun brandDao(): BrandDao
abstract fun groceryItemDao(): GroceryItemDao
abstract fun productDao():ProductDao

}