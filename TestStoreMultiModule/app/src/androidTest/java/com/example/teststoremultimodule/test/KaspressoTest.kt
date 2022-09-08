package com.example.teststoremultimodule.test

import androidx.test.ext.junit.rules.activityScenarioRule
import com.example.main_screen.R
import com.example.teststoremultimodule.MainActivity
import com.example.teststoremultimodule.screen.TestBottomShitFilter
import com.example.teststoremultimodule.screen.TestMainScreen
import com.example.teststoremultimodule.screen.TestMainScreen.pressBack
import com.example.teststoremultimodule.screen.TestMainScreen.scrollView
import com.example.teststoremultimodule.screen.TestMapScreen
import com.example.teststoremultimodule.screen.item.ItemBestsellerTest
import com.example.teststoremultimodule.screen.item.ItemHotSalesTest
import com.example.teststoremultimodule.screen.item.TestDetailScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class KaspressoTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() = run {
        step("1.Open and close is filter fragment") {

            TestMainScreen {
                scrollView.isDisplayed()
                filterButton.isDisplayed()
                filterButton.click()
            }

            TestBottomShitFilter {
                buttonGoBack.isDisplayed()
                buttonGoBack.click()
            }

        }

        step("2.Open and close is map fragment") {
            TestMainScreen {
                mapButton.isDisplayed()
                mapButton.click()
                pressBack()
            }
        }
        step("3.test tab layout") {
            TestMainScreen {
                tabLayout.click()
                //просто тестил что будет если нажать на таблайаут, оставил что бы не забыть
                //тут проверка на отображение нового фрагмента
                tabLayout.selectTab(2)
                //тут проверка на отображение нового фрагмента
                tabLayout.selectTab(0)
                hotSaleRecyclerView.isDisplayed()
            }
        }
        step("4.test edit test") {
            TestMainScreen {
                searchEditText.clearText()
                searchEditText.typeText("test text")
                searchEditText.hasText("test text")
                pressBack()
            }
        }

        step("5.test recycler") {
            TestMainScreen {
                hotSaleRecyclerView.childAt<ItemHotSalesTest>(1) {
                    isVisible()
                    itemButton.click()
                }
                scrollView.scrollToEnd()
                bestSellerRecyclerView.isDisplayed()
                bestSellerRecyclerView.childAt<ItemBestsellerTest>(1) {
                    itemFavorite.click()
                    itemFavorite.click()
                    itemImageButton.click()
                }
            }
            pressBack()
            TestMainScreen.tabLayout.selectTab(2)
        }
        step("6.test basket button") {
            TestMainScreen {
                basketButton.click()
            }
        }
    }

}