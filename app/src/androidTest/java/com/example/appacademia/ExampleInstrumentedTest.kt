package com.example.appacademia

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.appacademia.View.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    @Rule
    @JvmField
    val rule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.appacademia", appContext.packageName)
    }
    @Test
    fun user_can_enter_first_name(){
        onView(withId(R.id.etMainName)).perform(typeText("Gabriel"))
    }

    @Test
    fun user_can_enter_scond_name(){
        onView(withId(R.id.etMainSoberName)).perform(typeText("Brito"))
    }

    @Test
    fun user_can_enter_two_names(){
        onView(withId(R.id.etMainName)).perform(typeText("Gabriel"))
        onView(withId(R.id.etMainSoberName)).perform(typeText("Brito"))
        onView(withId(R.id.btnSubmit)).perform(click())
        onView(withId(R.id.txtName)).check(matches(withText("Olá, Gabriel Brito")))
    }

}