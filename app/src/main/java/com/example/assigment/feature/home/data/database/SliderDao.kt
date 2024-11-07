package com.example.assigment.feature.home.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assigment.feature.home.data.model.entity.SliderEntity

@Dao
interface SliderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sliders: List<SliderEntity>)

    @Query("SELECT * FROM sliders")
    fun getAllSliders(): LiveData<List<SliderEntity>>
}