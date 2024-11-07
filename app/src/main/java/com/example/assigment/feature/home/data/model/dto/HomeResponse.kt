package com.example.assigment.feature.home.data.model.dto
import com.fasterxml.jackson.annotation.JsonProperty

data class HomeResponse(
    @JsonProperty("sliderArray") val sliderArray: List<Slider>,
    @JsonProperty("topCategoryArray") val topCategoryArray: List<Category>,
    @JsonProperty("topBrandArray") val topBrandArray: List<BrandDto>,
    @JsonProperty("groceryItemsArray") val groceryItemsArray: List<GroceryItemDto>,
    @JsonProperty("homePageCallStatus") val homePageCallStatus: Boolean
)

data class Slider(
    @JsonProperty("image") val image: String
)

data class Category(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String
)

data class BrandDto(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String
)

data class GroceryItemDto(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String
)