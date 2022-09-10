package com.example.core.databasemodel.main.bestseller

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.databasemodel.detail.DetailEntity

@Dao
interface BestSellerDao {

    @Query("SELECT*FROM best_seller")
    fun getAll(): List<BestSellerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(BestSellerEntity: BestSellerEntity)
}