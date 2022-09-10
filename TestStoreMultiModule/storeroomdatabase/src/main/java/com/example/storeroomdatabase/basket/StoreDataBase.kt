package com.example.storeroomdatabase.basket

import android.content.Context
import androidx.room.*
import com.example.core.databasemodel.basket.BasketConverter
import com.example.core.databasemodel.basket.BasketDao
import com.example.core.databasemodel.basket.BasketEntity
import com.example.core.databasemodel.detail.DetailConverter
import com.example.core.databasemodel.detail.DetailDao
import com.example.core.databasemodel.detail.DetailEntity
import com.example.core.databasemodel.main.bestseller.BestSellerDao
import com.example.core.databasemodel.main.bestseller.BestSellerEntity
import com.example.core.databasemodel.main.hotsales.HotSalesDao
import com.example.core.databasemodel.main.hotsales.HotSalesEntity

@Database(
    entities = [
        BasketEntity::class,
        DetailEntity::class,
        HotSalesEntity::class,
        BestSellerEntity::class
    ], version = 1
)
@TypeConverters(BasketConverter::class, DetailConverter::class)
abstract class AppDataBaseBasket : RoomDatabase() {

    abstract fun basketDao(): BasketDao

    abstract fun detailDao(): DetailDao

    abstract fun hotSalesDao(): HotSalesDao

    abstract fun bestSellerDao(): BestSellerDao
}

fun initBasketDataBase(context: Context) = Room.databaseBuilder(
    context,
    AppDataBaseBasket::class.java,
    "StoreDataBase"
)
    .build()
