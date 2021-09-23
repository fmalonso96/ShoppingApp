package com.example.shoppingapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM productTableEntity")
    fun getAll(): List<ProductTableEntity>

    @Query("SELECT count(id) FROM productTableEntity WHERE id = :id")
    fun findById(id: Int): Int

    @Query("SELECT * FROM productTableEntity WHERE id = :id")
    fun getProduct(id: Int): ProductTableEntity?

    @Insert
    fun insertAll(vararg productTableEntity: ProductTableEntity)

    @Delete
    fun delete (productTable: ProductTableEntity)
}