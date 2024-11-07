package com.example.assigment.feature.home.domain.mapper

import com.example.assigment.feature.home.data.model.dto.BrandDto
import com.example.assigment.feature.home.data.model.dto.Category
 import com.example.assigment.feature.home.data.model.dto.GroceryItemDto
import com.example.assigment.feature.home.data.model.dto.Slider
import com.example.assigment.feature.home.data.model.entity.BrandEntity
import com.example.assigment.feature.home.data.model.entity.CategoryEntity
import com.example.assigment.feature.home.data.model.entity.GroceryItemEntity
import com.example.assigment.feature.home.data.model.entity.SliderEntity
import com.example.assigment.feature.home.domain.model.Brand

fun Slider.toSliderEntity(): SliderEntity {
    return SliderEntity(image = this.image)
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(_id = this._id, name = this.name, image = this.image)
}
fun BrandDto.toBrandEntity(): BrandEntity{
    return BrandEntity(_id = this._id, name = this.name, image = this.image)
}
fun BrandEntity.toBrand(): Brand = Brand(id = this._id, name = this.name, image = this.image)

fun SliderEntity.toSlider(): Slider = Slider(image = this.image)
fun CategoryEntity.toCategory():Category = Category(_id = this._id, name = this.name, image = this.image)
fun GroceryItemEntity.toGrocery():GroceryItemDto = GroceryItemDto(_id = this._id, name = this.name,image = this.image)

fun GroceryItemDto.toGroceryItemEntity(): GroceryItemEntity{
    return GroceryItemEntity(_id = this._id, name = this.name, image = this.image)
}