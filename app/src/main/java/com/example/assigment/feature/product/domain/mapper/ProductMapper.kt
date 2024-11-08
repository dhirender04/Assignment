package com.example.assigment.feature.product.domain.mapper

import androidx.lifecycle.LiveData
import androidx.room.TypeConverter
import com.example.assigment.feature.home.data.model.dto.BrandDto
import com.example.assigment.feature.home.data.model.entity.BrandEntity
import com.example.assigment.feature.product.data.model.dto.ProductDto
import com.example.assigment.feature.product.data.model.dto.ProductListItemDto
import com.example.assigment.feature.product.data.model.entity.ProductEntity
import com.example.assigment.feature.product.data.model.entity.ProductListItemEntity
import com.example.assigment.feature.product.domain.model.Product
import com.example.assigment.feature.product.domain.model.ProductListItem

fun ProductEntity.toProduct(): Product =
    Product(id = this._id, name = this.name, arraydata = this.arraydata.map {
        ProductListItem(
            val_id = it.val_id?:"0",
            name = it.name,
            image = it.image,
            price = it.price?:"0"
        )
    })

fun List<ProductEntity>.toProductList():List<Product>{
    return this.map { it.toProduct() }

}

fun ProductDto.toProductEntity(): ProductEntity {
    return ProductEntity(
        _id = this._id,
        name = this.name,
        arraydata = this.arraydata.map {
            ProductListItemEntity(
                val_id = it.val_id?:"0",
                name = it.name,
                image = it.image,
                price = it.price

            )
        }

    )
}






