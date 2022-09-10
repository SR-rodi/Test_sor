package com.example.core.databasemodel.main.hotsales

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HotSalesDao {
    @Query("SELECT*FROM hot_sales")
    fun getAll(): List<HotSalesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hotSalesEntity: HotSalesEntity)
}