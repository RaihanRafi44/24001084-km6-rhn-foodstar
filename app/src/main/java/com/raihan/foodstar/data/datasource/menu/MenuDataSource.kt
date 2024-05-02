package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.source.network.model.checkout.CheckoutRequestPayload
import com.raihan.foodstar.data.source.network.model.checkout.CheckoutResponse
import com.raihan.foodstar.data.source.network.model.menu.MenusResponse

interface MenuDataSource {
    suspend fun getMenuData(categorySlug: String? = null): MenusResponse

    suspend fun createOrder(payload: CheckoutRequestPayload): CheckoutResponse
}
