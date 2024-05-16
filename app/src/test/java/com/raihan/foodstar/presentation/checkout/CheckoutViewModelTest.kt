package com.raihan.foodstar.presentation.checkout

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.CartRepository
import com.raihan.foodstar.data.repository.MenuRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CheckoutViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var cartRepository: CartRepository

    @MockK
    lateinit var menuRepository: MenuRepository

    private lateinit var viewModel: CheckoutViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every { cartRepository.getCheckoutData() } returns
            flow {
                emit(ResultWrapper.Success(Triple(emptyList(), emptyList(), 0.0)))
            }
        viewModel =
            spyk(
                CheckoutViewModel(
                    cartRepository,
                    menuRepository,
                ),
            )
    }

    @Test
    fun getCheckoutData() {
    }

    @Test
    fun checkoutCart() {
    }

    @Test
    fun removeAllCart() {
        coEvery { cartRepository.deleteAll() } returns Unit
        viewModel.removeAllCart()
        coVerify { cartRepository.deleteAll() }
    }
}
