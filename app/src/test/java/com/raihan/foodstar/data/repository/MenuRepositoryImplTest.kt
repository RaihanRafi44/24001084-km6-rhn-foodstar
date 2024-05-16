package com.raihan.foodstar.data.repository

import app.cash.turbine.test
import com.raihan.foodstar.data.datasource.menu.MenuDataSource
import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.source.network.model.checkout.CheckoutResponse
import com.raihan.foodstar.data.source.network.model.menu.MenuItemResponse
import com.raihan.foodstar.data.source.network.model.menu.MenusResponse
import com.raihan.foodstar.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MenuRepositoryImplTest {
    @MockK
    lateinit var ds: MenuDataSource

    private lateinit var repo: MenuRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repo = MenuRepositoryImpl(ds)
    }

    @Test
    fun `getMenus success`() {
        val c1 =
            MenuItemResponse(
                alamatResto = "12",
                detail = "akakarrrr",
                harga = 2000,
                hargaFormat = "USD",
                imageUrl = "alalaladddd",
                nama = "Haii",
            )
        val c2 =
            MenuItemResponse(
                alamatResto = "13",
                detail = "akaka",
                harga = 4000,
                hargaFormat = "USD",
                imageUrl = "alalala",
                nama = "Hai",
            )
        val mockListProduct = listOf(c1, c2)
        val mockResponse = mockk<MenusResponse>()
        every { mockResponse.data } returns mockListProduct
        runTest {
            coEvery { ds.getMenuData("makanan") } returns mockResponse
            repo.getMenus("makanan").map {
                delay(100)
                it
            }.test {
                delay(201)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Success)
                coVerify { ds.getMenuData("makanan") }
            }
        }
    }

    @Test
    fun `getMenus loading`() {
        val c1 =
            MenuItemResponse(
                alamatResto = "12",
                detail = "akakarrrr",
                harga = 2000,
                hargaFormat = "USD",
                imageUrl = "alalaladddd",
                nama = "Haii",
            )
        val c2 =
            MenuItemResponse(
                alamatResto = "13",
                detail = "akaka",
                harga = 4000,
                hargaFormat = "Rp",
                imageUrl = "alalala",
                nama = "Hai",
            )
        val mockListProduct = listOf(c1, c2)
        val mockResponse = mockk<MenusResponse>()
        every { mockResponse.data } returns mockListProduct
        runTest {
            coEvery { ds.getMenuData("makanan") } returns mockResponse
            repo.getMenus("makanan").map {
                delay(100)
                it
            }.test {
                delay(110)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Loading)
                coVerify { ds.getMenuData("makanan") }
            }
        }
    }

    @Test
    fun `getMenus error`() {
        val mockListProduct = listOf<MenuItemResponse>()
        val mockResponse = mockk<MenusResponse>()
        every { mockResponse.data } returns mockListProduct
        runTest {
            coEvery { ds.getMenuData("makanan") } throws IllegalStateException("Mock Error")
            repo.getMenus("makanan").map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Error)
                coVerify { ds.getMenuData("makanan") }
            }
        }
    }

    @Test
    fun `getMenus empty`() {
        val mockListProduct = listOf<MenuItemResponse>()
        val mockResponse = mockk<MenusResponse>()
        every { mockResponse.data } returns mockListProduct
        runTest {
            coEvery { ds.getMenuData() } returns mockResponse
            repo.getMenus().map {
                delay(100)
                it
            }.test {
                delay(210)
                val actualData = expectMostRecentItem()
                Assert.assertTrue(actualData is ResultWrapper.Empty)
                coVerify { ds.getMenuData() }
            }
        }
    }

    @Test
    fun `createOrder success`() {
        val mockCart =
            listOf(
                Cart(
                    id = 1,
                    menuId = "124",
                    menuName = "Tes",
                    menuImgUrl = "hal",
                    menuPrice = 10.0,
                    itemQuantity = 2,
                    itemNotes = "Extra cheese",
                ),
            )
        val mockResponse =
            CheckoutResponse(
                code = 123,
                message = "haha",
                status = true,
            )
        runTest {
            coEvery { ds.createOrder(any()) } returns mockResponse
            repo.createOrder(mockCart).map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                Assert.assertTrue(data is ResultWrapper.Success)
                coVerify {
                    ds.createOrder(
                        match {
                            it.orders.size == 1 &&
                                it.orders[0].productId == "124" &&
                                it.orders[0].quantity == 2 &&
                                it.orders[0].notes == "Extra cheese"
                        },
                    )
                }
            }
        }
    }

    @Test
    fun `createOrder success productId null`() {
        val mockCart =
            listOf(
                Cart(
                    id = 1,
                    menuId = "123",
                    menuName = "test",
                    menuImgUrl = "halo",
                    menuPrice = 10.0,
                    itemQuantity = 2,
                    itemNotes = "Extra cheese",
                ),
            )
        val mockResponse =
            CheckoutResponse(
                code = 123,
                message = "haha",
                status = true,
            )
        runTest {
            coEvery { ds.createOrder(any()) } returns mockResponse
            repo.createOrder(mockCart).map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                Assert.assertTrue(data is ResultWrapper.Success)
                coVerify {
                    ds.createOrder(
                        match {
                            it.orders.size == 1 &&
                                it.orders[0].quantity == 2 &&
                                it.orders[0].notes == "Extra cheese"
                        },
                    )
                }
            }
        }
    }

    @Test
    fun `createOrder loading`() {
        val mockCart = listOf<Cart>()
        val mockResponse =
            CheckoutResponse(
                code = 123,
                message = "haha",
                status = true,
            )
        runTest {
            coEvery { ds.createOrder(any()) } returns mockResponse
            repo.createOrder(mockCart).map {
                delay(100)
                it
            }.test {
                delay(110)
                val data = expectMostRecentItem()
                Assert.assertTrue(data is ResultWrapper.Loading)
                coVerify { ds.createOrder(any()) }
            }
        }
    }

    @Test
    fun `createOrder error`() {
        val mockCart = listOf<Cart>()
        runTest {
            coEvery { ds.createOrder(any()) } throws IllegalStateException("Error")
            repo.createOrder(mockCart).map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                Assert.assertTrue(data is ResultWrapper.Error)
                coVerify { ds.createOrder(any()) }
            }
        }
    }
}
