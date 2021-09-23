package com.example.shoppingapp.presenter.productdescription

import com.example.shoppingapp.interfaces.productdescription.ProductDescriptionContract
import com.example.shoppingapp.model.productdescription.ProductDescriptionModel
import com.example.shoppingapp.model.shop.ShopProduct
import com.example.shoppingapp.view.productdescription.ProductDescriptionView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDescriptionPresenter(private val model: ProductDescriptionModel, private val view: ProductDescriptionView) :
    ProductDescriptionContract.ProductDescriptionPresenter {

    init {
        view.onClickFavourite { onClickFavouriteButton(it) }
        setFavourite(view.receiveProduct())
    }

    override fun onClickFavouriteButton(product: ShopProduct) {
        CoroutineScope(Dispatchers.IO).launch {
            if (model.checkProductInDb(product.id)){
                model.deleteProduct(product)
            }else{
                model.saveProduct(product)
            }
        }
    }

    private fun setFavourite(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val isOrNot = model.checkProductInDb(id)
            withContext(Dispatchers.Main){
                view.setFavouriteStar(isOrNot)
            }
        }
    }
}