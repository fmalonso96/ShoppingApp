package com.example.shoppingapp.interfaces.shop

import com.example.shoppingapp.model.shop.ShopProduct

interface ShopContract {

    interface ShopModel {
        suspend fun getProducts(): List<ShopProduct>
    }

    interface ShopPresenter {
    }

    interface ShopView {
        fun showProducts(products: List<ShopProduct>)
        fun expandProductView(product: ShopProduct)
        fun showError()
    }
}