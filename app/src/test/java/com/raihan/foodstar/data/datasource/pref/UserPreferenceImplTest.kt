package com.raihan.foodstar.data.datasource.pref

import android.content.SharedPreferences
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserPreferenceImplTest {
    private lateinit var pref: UserPreference

    private lateinit var sharedPreferences: SharedPreferences

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sharedPreferences = mockk(relaxed = true)
        pref = UserPreferenceImpl(sharedPreferences)
    }

    @Test
    fun isUsingGridMode() {
        every { sharedPreferences.getBoolean(UserPreferenceImpl.KEY_IS_USING_GRID_MODE, false) } returns false

        val result = pref.isUsingGridMode()
        assertEquals(false, result)

        verify { sharedPreferences.getBoolean(UserPreferenceImpl.KEY_IS_USING_GRID_MODE, false) }
    }

    @Test
    fun setUsingGridMode() {
    }
}
