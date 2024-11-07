package com.example.assigment.feature.home.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sliders")
data class SliderEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val image: String
)

