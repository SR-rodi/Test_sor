package com.example.core.databasemodel.basket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BasketDao {
    @Query("SELECT*FROM basket")
    fun getAll(): BasketEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(basketDataBase: BasketEntity)
}