package com.example.shoppingapp.model.productdescription

import com.example.shoppingapp.database.ProductDao
import com.example.shoppingapp.database.ProductTableEntity
import com.example.shoppingapp.interfaces.productdescription.ProductDescriptionContract
import com.example.shoppingapp.model.shop.ShopProduct

class ProductDescriptionModel(val productDao: ProductDao): ProductDescriptionContract.ProductDescriptionModel {

    override fun saveProduct(product: ShopProduct) {
        val table = ProductTableEntity(product.id,product.title, product.description, product.image)
        productDao.insertAll(table)
    }

    override fun deleteProduct(product: ShopProduct) {
        val table = ProductTableEntity(product.id,product.title, product.description, product.image)
        productDao.delete(table)
    }

    override fun checkProductInDb(id: Int): Boolean {
        return productDao.findById(id) > 0
    }
}