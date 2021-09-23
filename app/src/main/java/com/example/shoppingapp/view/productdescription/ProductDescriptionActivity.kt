package com.example.shoppingapp.view.productdescription

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingapp.R
import com.example.shoppingapp.database.DatabaseFavourite
import com.example.shoppingapp.interfaces.productdescription.ProductDescriptionContract
import com.example.shoppingapp.model.productdescription.ProductDescriptionModel
import com.example.shoppingapp.presenter.productdescription.ProductDescriptionPresenter

class ProductDescriptionActivity : AppCompatActivity() {

    private lateinit var presenter: ProductDescriptionContract.ProductDescriptionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_description)
        val db = DatabaseFavourite.getDatabase(applicationContext).productDao()
        presenter = ProductDescriptionPresenter(ProductDescriptionModel(db), ProductDescriptionView(this))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}