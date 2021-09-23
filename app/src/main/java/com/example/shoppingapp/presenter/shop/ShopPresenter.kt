package com.example.shoppingapp.presenter.shop

import com.example.shoppingapp.interfaces.shop.ShopContract
import com.example.shoppingapp.model.shop.ShopModel
import com.example.shoppingapp.view.shop.ShopView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopPresenter(private val model: ShopModel, private val view: ShopView) :
    ShopContract.ShopPresenter {

    init {
        CoroutineScope(Dispatchers.Main).launch {
            view.showProducts(model.getProducts())
        }
    }
}