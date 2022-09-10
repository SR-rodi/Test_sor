package com.example.teststoremultimodule.test

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.main_screen.R
import com.example.teststoremultimodule.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class EspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testTwo() {
        onView(withId(R.id.recycler_vew_hot_sales)).check(matches(isDisplayed()))
    }

    @Test
    fun testOne() {
            onView(withId(R.id.recycler_vew_hot_sales))
                .perform(
                    RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2)
                )
        onView(withId(R.id.basket_button)).perform(click())
        pressBack()
        onView(withId(R.id.recycler_vew_hot_sales))
            .perform(
                RecyclerViewActions.scrollToPosition <RecyclerView.ViewHolder> (1)
            )
        repeat(15) {
            onView(withId(R.id.qr)).perform(click())
        }
        onView(withId(R.id.maine_scroll)).perform(scrollTo())
    }
}
