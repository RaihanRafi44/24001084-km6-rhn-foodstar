package com.raihan.foodstar.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.CategoryRepository
import com.raihan.foodstar.data.repository.MenuRepository
import com.raihan.foodstar.data.repository.UserPreferenceRepository
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import com.raihan.foodstar.tools.getOrAwaitValue
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
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

class HomeViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var categoryRepository: CategoryRepository

    @MockK
    lateinit var menuRepository: MenuRepository

    @MockK
    lateinit var userPreferenceRepository: UserPreferenceRepository

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every { userPreferenceRepository.isUsingGridMode() } returns true
        viewModel =
            spyk(
                HomeViewModel(
                    categoryRepository,
                    menuRepository,
                    userPreferenceRepository,
                    userRepository,
                ),
            )
    }

    @Test
    fun isUsingGridMode() {
    }

    @Test
    fun getListMode() {
    }

    @Test
    fun changeListMode() {
    }

    @Test
    fun getMenu() {
        coEvery { menuRepository.getMenus() } returns
            flow {
                emit(ResultWrapper.Success(listOf(mockk(), mockk())))
            }
        coEvery { menuRepository.getMenus(any()) } returns
            flow {
                emit(ResultWrapper.Success(listOf(mockk(), mockk())))
            }
        val result = viewModel.getMenu().getOrAwaitValue()
        assertEquals(2, result.payload?.size)
        coVerify { menuRepository.getMenus(any()) }
    }

    @Test
    fun getCategory() {
        every { categoryRepository.getCategories() } returns
            flow {
                emit(ResultWrapper.Success(listOf(mockk(), mockk())))
            }
        val result = viewModel.getCategory().getOrAwaitValue()
        assertEquals(2, result.payload?.size)
        verify { categoryRepository.getCategories() }
    }

    @Test
    fun getCurrentUser() {
    }
}
