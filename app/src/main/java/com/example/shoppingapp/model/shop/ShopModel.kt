package com.example.shoppingapp.model.shop

import com.example.shoppingapp.interfaces.APIService
import com.example.shoppingapp.interfaces.shop.ShopContract
import com.example.shoppingapp.model.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShopModel : ShopContract.ShopModel {

    override suspend fun getProducts(): List<ShopProduct> {
        try {
            return withContext(Dispatchers.IO) {
                Retrofit.getRetrofit().create(APIService::class.java).callProducts()
            }
        } catch (e: Exception) {
            return emptyList()
        }
    }
}