package com.sapuglha.tictactoe.ui


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import com.sapuglha.tictactoe.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun playerXWinsTest() {
        onView(allOf(withId(R.id.activity_main_board_0_0), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.activity_main_board_1_0), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.activity_main_board_1_1), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.activity_main_board_2_1), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.activity_main_board_2_2), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.activity_main_label_winner), withText("X"), isDisplayed()))
                .check(matches(withText("X")))

    }
}
