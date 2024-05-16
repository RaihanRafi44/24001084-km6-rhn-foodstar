package com.raihan.foodstar.presentation.register

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import com.raihan.foodstar.tools.getOrAwaitValue
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class RegisterViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel =
            spyk(
                RegisterViewModel(
                    userRepository,
                ),
            )
    }

    @Test
    fun doRegister() {
        val email = "hai@bang.com"
        val fullName = "ka"
        val password = "qwe"
        coEvery { userRepository.doRegister(email, fullName, password) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }

        val result = viewModel.doRegister(email, fullName, password).getOrAwaitValue()

        assertEquals(true, result.payload)
        coVerify { userRepository.doRegister(email, fullName, password) }
    }
}
