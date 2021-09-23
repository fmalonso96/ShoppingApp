package com.example.shoppingapp.model.shop

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class ShopProduct(
    val id: Int,
    val title: String,
    val description: String,
    val image: String
) : Serializable