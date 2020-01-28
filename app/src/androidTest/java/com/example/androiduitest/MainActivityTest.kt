package com.example.androiduitest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun test_activityInView() {

        // This is how you open an simulated activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)


        // This is how you check if the view is visible
        onView(withId(R.id.main_activity_main_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_titleAndButton() {

        // This is how you open an simulated activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // This is how you check if the view is visible
        onView(withId(R.id.activity_main_title))
            .check(matches(isDisplayed()))

        // This is ANOTHER way how you check if the view is visible
        onView(withId(R.id.button_next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun test_if_title_text_displayed() {

        // This is how you open an simulated activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // This is how you check if text matches
        onView(withId(R.id.activity_main_title))
            .check(matches(withText("MainActivity")))
    }

    @Test
    fun go_to_second_activity() {

        // This is how you open an simulated activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // This is how you perform a click
        onView(withId(R.id.button_next_activity))
            .perform(click())

        // This is how you check if the view is visible
        onView(withId(R.id.second_activity_main_layout)).check(matches(isDisplayed()))

    }

    @Test
    fun go_to_second_activity_and_back() {

        // This is how you open an simulated activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // This is how you perform a click
        onView(withId(R.id.button_next_activity))
            .perform(click())

        // This is how you perform a click
        onView(withId(R.id.button_back))
            .perform(click())

        // This is how you check if the view is visible
        onView(withId(R.id.main_activity_main_layout))
            .check(matches(isDisplayed()))


    }

}