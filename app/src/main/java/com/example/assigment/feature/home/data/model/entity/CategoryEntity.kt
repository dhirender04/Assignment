package com.example.assigment.feature.home.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey val _id: String,
    val name: String,
    val image: String
)