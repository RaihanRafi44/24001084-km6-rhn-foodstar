package com.raihan.foodstar.presentation.splashscreen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class SplashViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: SplashViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel =
            spyk(
                SplashViewModel(
                    userRepository,
                ),
            )
    }

    @Test
    fun isUserLoggedIn() {
        every { userRepository.isLoggedIn() } returns true
        val result = viewModel.isUserLoggedIn()
        verify { userRepository.isLoggedIn() }
        Assert.assertEquals(true, result)
    }
}
