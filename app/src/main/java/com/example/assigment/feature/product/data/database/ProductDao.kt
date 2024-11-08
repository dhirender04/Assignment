package com.example.assigment.feature.product.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
  import com.example.assigment.feature.product.data.model.entity.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(categories: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<ProductEntity>>

    // You mightneed additional queries for specific data access needs
}