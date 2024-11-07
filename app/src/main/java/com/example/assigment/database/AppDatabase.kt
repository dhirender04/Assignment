package com.example.assigment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assigment.feature.home.data.database.BrandDao
import com.example.assigment.feature.home.data.database.CategoryDao
import com.example.assigment.feature.home.data.database.GroceryItemDao
import com.example.assigment.feature.home.data.database.SliderDao
import com.example.assigment.feature.home.data.model.dto.Slider
import com.example.assigment.feature.home.data.model.entity.BrandEntity
import com.example.assigment.feature.home.data.model.entity.CategoryEntity
import com.example.assigment.feature.home.data.model.entity.GroceryItemEntity
import com.example.assigment.feature.home.data.model.entity.SliderEntity

@Database(entities = [BrandEntity::class, CategoryEntity::class, GroceryItemEntity::class,SliderEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
abstract fun sliderDao(): SliderDao
abstract fun categoryDao(): CategoryDao
abstract fun brandDao(): BrandDao
abstract fun groceryItemDao(): GroceryItemDao

}