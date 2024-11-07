package com.example.assigment.feature.product.data.model.dto

 
import com.fasterxml.jackson.annotation.JsonProperty

data class MaintenanceResponse(
    @JsonProperty("_id") val _id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("arraydata") val arraydata: List<SubCategory>
)

data class SubCategory(
    @JsonProperty("_id") val val_id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String
)