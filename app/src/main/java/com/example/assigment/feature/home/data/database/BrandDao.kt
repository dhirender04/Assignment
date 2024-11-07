package com.example.assigment.feature.home.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assigment.feature.home.data.model.entity.BrandEntity
@Dao
interface BrandDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(brands: List<BrandEntity>)

    @Query("SELECT * FROM brands")
    fun getAllBrands(): LiveData<List<BrandEntity>>
}