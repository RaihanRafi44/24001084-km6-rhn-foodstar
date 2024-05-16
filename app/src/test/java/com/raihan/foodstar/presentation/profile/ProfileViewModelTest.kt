package com.raihan.foodstar.presentation.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import com.raihan.foodstar.tools.getOrAwaitValue
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ProfileViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: ProfileViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel =
            spyk(
                ProfileViewModel(
                    userRepository,
                ),
            )
    }

    @Test
    fun isEditMode() {
    }

    @Test
    fun doLogout() {
        every { userRepository.doLogout() } returns true
        val result = viewModel.doLogout()
        verify { userRepository.doLogout() }
        assertEquals(true, result)
    }

    @Test
    fun updateProfileName() {
        val fullName = "John Doe"
        coEvery { userRepository.updateProfile(fullName) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }
        val result = viewModel.updateProfileName(fullName).getOrAwaitValue()
        assertEquals(true, result.payload)
        coVerify { userRepository.updateProfile(fullName) }
    }

    @Test
    fun getCurrentUser() {
    }

    @Test
    fun createChangePwdRequest() {
    }

    @Test
    fun changeEditMode() {
    }
}
