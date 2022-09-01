package com.example.basket_screen.data

import com.example.core.databasemodel.basket.BasketDao
import com.example.core.dtomodel.basketscreen.BasketDto
import com.example.core.dtomodel.basketscreen.BasketPhoneDto
import com.example.stor_api.api.StoreApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.mock


class BasketRepositoryNetworkTest {

    private val storeApi by lazy { mock<StoreApi>() }
    private val testListBasketDto = listOf(BasketDto(352, "test img1", 125, "test title"))
    private val testDto = BasketPhoneDto(testListBasketDto, "free", "test id", 200)

    @ExperimentalCoroutinesApi
    @Test
    fun `get data from network`() = runTest {

        Mockito.`when`(storeApi.getBasketIndo()).thenReturn(testDto)

        Assertions.assertEquals(testDto,
            BasketRepositoryNetwork(storeApi).getBasketFromNetwork())
    }
}