package com.example.shoppingapp.interfaces

import com.example.shoppingapp.model.shop.ShopProduct
import retrofit2.http.GET

interface APIService {
    @GET("products/")
    suspend fun callProducts(): List<ShopProduct>
}