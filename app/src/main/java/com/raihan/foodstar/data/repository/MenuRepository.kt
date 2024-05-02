package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getMenus(categorySlug: String? = null): Flow<ResultWrapper<List<Menu>>>

    fun createOrder(products: List<Cart>): Flow<ResultWrapper<Boolean>>
}
