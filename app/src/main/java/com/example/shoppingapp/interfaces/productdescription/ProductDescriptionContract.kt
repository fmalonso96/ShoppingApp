package com.example.shoppingapp.interfaces.productdescription

import com.example.shoppingapp.model.shop.ShopProduct

interface ProductDescriptionContract {

    interface ProductDescriptionModel {
        fun saveProduct(product: ShopProduct)
        fun deleteProduct(product: ShopProduct)
        fun checkProductInDb(id: Int): Boolean
    }

    interface ProductDescriptionPresenter {
        fun onClickFavouriteButton(product: ShopProduct)
    }

    interface ProductDescriptionView {
        fun setProductData(product: ShopProduct)
        fun onClickFavourite(onClick: (ShopProduct) -> Unit)
        fun favouriteIsChecked(): Boolean
        fun setFavouriteStar(boolean: Boolean)
        fun receiveProduct(): Int
    }
}