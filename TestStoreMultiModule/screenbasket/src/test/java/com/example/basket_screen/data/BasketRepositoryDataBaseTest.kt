package com.example.basket_screen.data

import com.example.core.databasemodel.basket.BasketDao
import com.example.core.databasemodel.basket.BasketEntity
import com.example.core.dtomodel.basketscreen.BasketDto
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.kotlin.mock

class BasketRepositoryDataBaseTest {
    private val basketDaoTest by lazy { mock<BasketDao>() }
    private val testListBasketDto = listOf(BasketDto(352, "test img1", 125, "test title"))
    private val testEntity = BasketEntity("test id", "test free", 125, testListBasketDto)

    @Test
    fun `test get data from BasketRepository`() {

        `when`(basketDaoTest.getAll()).thenReturn(testEntity)


        assertEquals(testEntity, BasketRepositoryDataBase(basketDaoTest).getBasketFromDataBase())

        Mockito.verify(basketDaoTest, times(0)).insert(testEntity)
    }

    @Test
    fun `test add data in BasketRepository`() {

        BasketRepositoryDataBase(basketDaoTest).addToBasketDataBase(testEntity)

        // assertEquals(testRepositoryDataBase.getBasketFromDataBase(), testEntity)
        //  assertTrue(testRepositoryDataBase.getBasketFromDataBase()==null) так не работает
        Mockito.verify(basketDaoTest, times(1)).insert(testEntity)
    }
}