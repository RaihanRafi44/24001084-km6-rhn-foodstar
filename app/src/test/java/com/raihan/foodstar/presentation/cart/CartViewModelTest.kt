package com.raihan.foodstar.presentation.cart

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raihan.foodstar.data.repository.CartRepository
import com.raihan.foodstar.data.repository.UserRepository
import com.raihan.foodstar.tools.MainCoroutineRule
import com.raihan.foodstar.tools.getOrAwaitValue
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CartViewModelTest {
    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule: TestRule = MainCoroutineRule(UnconfinedTestDispatcher())

    @MockK
    lateinit var cartRepository: CartRepository

    @MockK
    lateinit var userRepository: UserRepository

    private lateinit var viewModel: CartViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel =
            spyk(
                CartViewModel(
                    cartRepository,
                    userRepository,
                ),
            )
    }

    @Test
    fun isLoggedIn() {
        every { userRepository.isLoggedIn() } returns true
        val result = viewModel.isLoggedIn()
        verify { userRepository.isLoggedIn() }
        Assert.assertEquals(true, result)
    }

    @Test
    fun getAllCarts() {
        every { cartRepository.getUserCartData() } returns
            flow {
                emit(
                    ResultWrapper.Success(
                        Pair(listOf(mockk(relaxed = true), mockk(relaxed = true)), 8000.0),
                    ),
                )
            }
        val result = viewModel.getAllCarts().getOrAwaitValue()
        Assert.assertEquals(2, result.payload?.first?.size)
        Assert.assertEquals(8000.0, result.payload?.second)
    }

    @Test
    fun increaseCart() {
        every { cartRepository.increaseCart(any()) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }
        viewModel.increaseCart(mockk())
        verify { cartRepository.increaseCart(any()) }
    }

    @Test
    fun decreaseCart() {
        every { cartRepository.decreaseCart(any()) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }
        viewModel.decreaseCart(mockk())
        verify { cartRepository.decreaseCart(any()) }
    }

    @Test
    fun removeCarts() {
        every { cartRepository.deleteCart(any()) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }
        viewModel.removeCarts(mockk())
        verify { cartRepository.deleteCart(any()) }
    }

    @Test
    fun setCartNotes() {
        every { cartRepository.setCartNotes(any()) } returns
            flow {
                emit(ResultWrapper.Success(true))
            }
        viewModel.setCartNotes(mockk())
        verify { cartRepository.setCartNotes(any()) }
    }
}
