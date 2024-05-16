package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.source.network.model.checkout.CheckoutRequestPayload
import com.raihan.foodstar.data.source.network.model.checkout.CheckoutResponse
import com.raihan.foodstar.data.source.network.model.menu.MenusResponse
import com.raihan.foodstar.data.source.network.services.FoodStarApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MenuApiDataSourceTest {
    @MockK
    lateinit var service: FoodStarApiService

    private lateinit var ds: MenuDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        ds = MenuApiDataSource(service)
    }

    @Test
    fun getMenuData() {
        runTest {
            val mockResponse = mockk<MenusResponse>(relaxed = true)
            coEvery { service.getMenus(any()) } returns mockResponse
            val actualResponse = ds.getMenuData("foods")
            coVerify { service.getMenus(any()) }
            assertEquals(actualResponse, mockResponse)
        }
    }

    @Test
    fun createOrder() {
        runTest {
            val mockRequest = mockk<CheckoutRequestPayload>(relaxed = true)
            val mockResponse = mockk<CheckoutResponse>(relaxed = true)
            coEvery { service.createOrder(any()) } returns mockResponse
            val actualResponse = ds.createOrder(mockRequest)
            coVerify { service.createOrder(any()) }
            assertEquals(actualResponse, mockResponse)
        }
    }
}
