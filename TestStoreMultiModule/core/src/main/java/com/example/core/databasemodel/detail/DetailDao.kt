package com.example.core.databasemodel.detail

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailDao {
    @Query("SELECT*FROM detail")
    fun getAll(): DetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(DataBase: DetailEntity)
}