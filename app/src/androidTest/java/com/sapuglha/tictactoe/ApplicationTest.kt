package com.sapuglha.tictactoe

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApplicationTest {

    @Test
    @Throws(Exception::class)
    fun validatePackagenName() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.sapuglha.tictactoe", appContext.packageName)
    }
}
