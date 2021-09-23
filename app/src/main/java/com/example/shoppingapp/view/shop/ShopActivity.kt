package com.example.shoppingapp.view.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapp.interfaces.shop.ShopContract
import com.example.shoppingapp.model.shop.ShopModel
import com.example.shoppingapp.presenter.shop.ShopPresenter

class ShopActivity : AppCompatActivity() {

    private lateinit var presenter: ShopContract.ShopPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ShopPresenter(ShopModel(), ShopView(this))
    }
}