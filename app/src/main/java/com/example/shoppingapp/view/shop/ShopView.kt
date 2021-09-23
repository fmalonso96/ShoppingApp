package com.example.shoppingapp.view.shop

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoppingapp.R
import com.example.shoppingapp.databinding.ShopBinding
import com.example.shoppingapp.interfaces.shop.ShopContract
import com.example.shoppingapp.model.ProductsAdapter
import com.example.shoppingapp.model.shop.ShopProduct
import com.example.shoppingapp.view.productdescription.ProductDescriptionActivity

class ShopView(private val activity: Activity) : ShopContract.ShopView {

    private val binding: ShopBinding = ShopBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun showProducts(products: List<ShopProduct>) {
        val adapter = ProductsAdapter(products, onClick = {
            expandProductView(it)
        })
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 2)
    }

    override fun expandProductView(product: ShopProduct) {
        val intent= Intent(activity, ProductDescriptionActivity::class.java)
        intent.putExtra("product", product)
        startActivity(activity, intent, null)
    }

    override fun showError() {
        val alert = AlertDialog.Builder(activity)
        alert.setTitle(R.string.alert_title)
        alert.setMessage(R.string.alert_message)
        alert.setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        alert.show()
    }
}