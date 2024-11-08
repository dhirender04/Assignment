package com.example.assigment.feature.product.data.model.entity

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.Random


@Entity(tableName = "products")
@TypeConverters(ProductListItemListConverter::class)
@JsonInclude(JsonInclude.Include.ALWAYS)
data class ProductEntity(
    @PrimaryKey  @JsonProperty("id") val _id: String,
    @JsonProperty("product_name")  val name: String,
    @JsonProperty("arraydata") val arraydata: List<ProductListItemEntity> // Assuming ProductList is an entity as well
)

@Entity(tableName = "product_list_items")
@JsonInclude(JsonInclude.Include.ALWAYS) //
data class ProductListItemEntity(
    @PrimaryKey  @JsonProperty("val_id") val val_id: String,
    @JsonProperty("name") val name: String,
    @JsonProperty("image") val image: String,
    @JsonProperty("price")  var price: String?=null
){
    init {
        if (price == null) {
            price = generateRandomPrice() // Assign the random price if null
        }
    }
}

fun generateRandomPrice(): String {
    val random = Random()
    val price = random.nextInt(1000) + 1 // Generate a price between 1 and 1000
    return "$$price" // Format the price as a string with a dollar sign
}

class ProductListItemListConverter {
    private val objectMapper = ObjectMapper()

    @TypeConverter
    fun fromProductListItemListToString(productListItemList: List<ProductListItemEntity>): String {
        // Convert the list to a JSON string using Jackson
        return objectMapper.writeValueAsString(productListItemList)
    }

    @TypeConverter
    fun fromStringtoProductListItemList(value : String): List<ProductListItemEntity>
    {
        // Convert the JSON string back to a list using Jackson
        val type = object : TypeReference<List<ProductListItemEntity>>() {}
        return objectMapper.readValue(value, type)
    }
}
