package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.pref.UserPreference
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserPreferenceRepositoryImplTest {
    @MockK
    lateinit var ds: UserPreference

    private lateinit var pref: UserPreferenceRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        pref = UserPreferenceRepositoryImpl(ds)
    }

    @Test
    fun isUsingGridMode() {
        every { ds.isUsingGridMode() } returns true
        val actualResult = pref.isUsingGridMode()
        verify { ds.isUsingGridMode() }
        Assert.assertEquals(true, actualResult)
    }

    @Test
    fun setUsingGridMode() {
        every { ds.setUsingGridMode(any()) } returns Unit
        pref.setUsingGridMode(true)
        verify { ds.setUsingGridMode(any()) }
    }
}
