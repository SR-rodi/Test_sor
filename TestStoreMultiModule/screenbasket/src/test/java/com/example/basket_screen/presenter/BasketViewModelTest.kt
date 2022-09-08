package com.example.basket_screen.presenter

import com.example.basket_screen.data.BasketRepositoryDataBase
import com.example.basket_screen.domain.BasketUseCase
import com.example.basket_screen.presentation.viewModel.BasketViewModel
import com.example.core.databasemodel.basket.BasketEntity
import com.example.core.dtomodel.basketscreen.BasketDto
import com.example.core.dtomodel.basketscreen.BasketPhoneDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.mock


class BasketViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val basketUseCase by lazy { mock<BasketUseCase>() }
    private val basketDtaBase by lazy { mock<BasketRepositoryDataBase>() }
    private val testListBasketDto = listOf(BasketDto(352, "test img1", 125, "test title"))
    private val testDto = BasketPhoneDto(testListBasketDto, "free", "test id", 200)
    private val testEntity = BasketEntity("test id", "free", 200, testListBasketDto)

    private val viewModelTest by lazy {
        BasketViewModel(
            basketUseCase,
            basketDtaBase,
            mainDispatcherRule.testOne
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup()= runTest{
        Mockito.`when`(basketUseCase.getBasketFromNetwork()).thenReturn(testDto)
    }

    @Test
    fun `test Loading view model if Database is not empty`() {

        Mockito.`when`(basketDtaBase.getBasketFromDataBase()).thenReturn(testEntity)


        viewModelTest.getInfo()

        Assertions.assertEquals(testEntity, viewModelTest.isBasket.replayCache.first())
    }

    @Test
    fun `checking the number of downloads of the getBasketFromDataBase method`(){
        Mockito.`when`(basketDtaBase.getBasketFromDataBase()).thenReturn(testEntity)

        viewModelTest.getInfo()

        Mockito.verify(basketDtaBase, Mockito.times(1)).getBasketFromDataBase()
    }


    @Test
    fun `test Loading view model if Database is empty`() {

        Mockito.`when`(basketDtaBase.getBasketFromDataBase()).thenReturn(null)

        viewModelTest.getInfo()

        Assertions.assertEquals(testEntity, viewModelTest.isBasket.replayCache.first())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `checking the number of downloads of the get method`() = runTest{
        Mockito.`when`(basketDtaBase.getBasketFromDataBase()).thenReturn(null)

        viewModelTest.getInfo()

        Mockito.verify(basketUseCase, Mockito.times(1)).getBasketFromNetwork()
    }

    @Test
    fun `test status Loading show detector`(){

        viewModelTest.getInfo()

        Assertions.assertFalse(viewModelTest.isLoading.value)
    }
}

