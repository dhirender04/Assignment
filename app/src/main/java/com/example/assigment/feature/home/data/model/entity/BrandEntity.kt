package com.example.assigment.feature.home.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brands")
data class BrandEntity(
    @PrimaryKey val _id: String,
    val name: String,
    val image: String
)