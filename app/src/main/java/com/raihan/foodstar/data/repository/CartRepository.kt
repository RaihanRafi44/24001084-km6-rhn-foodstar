package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.model.PriceItem
import com.raihan.foodstar.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getUserCartData(): Flow<ResultWrapper<Pair<List<Cart>, Double>>>

    fun getCheckoutData(): Flow<ResultWrapper<Triple<List<Cart>, List<PriceItem>, Double>>>

    fun createCart(
        menu: Menu,
        quantity: Int,
        notes: String? = null,
    ): Flow<ResultWrapper<Boolean>>

    fun decreaseCart(item: Cart): Flow<ResultWrapper<Boolean>>

    fun increaseCart(item: Cart): Flow<ResultWrapper<Boolean>>

    fun setCartNotes(item: Cart): Flow<ResultWrapper<Boolean>>

    fun deleteCart(item: Cart): Flow<ResultWrapper<Boolean>>

    suspend fun checkout(items: List<Cart>): Flow<ResultWrapper<Boolean>>

    suspend fun deleteAll()
}
