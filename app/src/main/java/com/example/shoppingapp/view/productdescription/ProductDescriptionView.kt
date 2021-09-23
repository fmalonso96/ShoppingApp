package com.example.shoppingapp.view.productdescription

import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.shoppingapp.databinding.ActivityProductDescriptionBinding
import com.example.shoppingapp.interfaces.productdescription.ProductDescriptionContract
import com.example.shoppingapp.model.shop.ShopProduct

class ProductDescriptionView (private val activity: Activity): ProductDescriptionContract.ProductDescriptionView{

    private val binding: ActivityProductDescriptionBinding = ActivityProductDescriptionBinding.inflate(activity.layoutInflater)
    private val product: ShopProduct = activity.intent.getSerializableExtra("product") as ShopProduct

    init {
        activity.setContentView(binding.root)
        setProductData(product)
    }

    override fun setProductData(product: ShopProduct) {
        val productImage: ImageView = binding.ivProductDescription
        val productTitle: TextView = binding.tvProductDescriptionTitle
        val productDescription: TextView = binding.tvProductDescription

        Glide.with(activity).load(product.image).into(productImage)
        productTitle.text = product.title
        productDescription.text = product.description
    }

    override fun onClickFavourite(onClick: (ShopProduct) -> Unit) {
        binding.favourite.setOnClickListener{
            onClick(product)
        }
    }

    override fun favouriteIsChecked(): Boolean {
        return binding.favourite.isChecked
    }

    override fun setFavouriteStar(boolean: Boolean) {
        binding.favourite.isChecked = boolean
    }

    override fun receiveProduct(): Int {
        return product.id
    }
}