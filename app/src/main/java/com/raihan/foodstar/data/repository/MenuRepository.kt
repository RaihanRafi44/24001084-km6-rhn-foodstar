package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.menu.MenuDataSource
import com.raihan.foodstar.data.mapper.toMenus
import com.raihan.foodstar.data.model.Cart
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.source.network.model.checkout.CheckoutItemPayload
import com.raihan.foodstar.data.source.network.model.checkout.CheckoutRequestPayload
import com.raihan.foodstar.utils.ResultWrapper
import com.raihan.foodstar.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getMenus(categorySlug : String? = null) : Flow<ResultWrapper<List<Menu>>>
    fun createOrder(products: List<Cart>): Flow<ResultWrapper<Boolean>>
}

class MenuRepositoryImpl(private val dataSource: MenuDataSource) : MenuRepository {
    override fun getMenus(categorySlug: String?): Flow<ResultWrapper<List<Menu>>> {
        return proceedFlow {
            dataSource.getMenuData(categorySlug).data.toMenus()
        }
    }

    override fun createOrder(products: List<Cart>): Flow<ResultWrapper<Boolean>> {
        return proceedFlow {
            dataSource.createOrder(CheckoutRequestPayload(
                orders = products.map {
                    CheckoutItemPayload(
                        notes = it.itemNotes,
                        productId = it.menuId.orEmpty(),
                        quantity = it.itemQuantity
                    )
                }
            )).status ?: false
        }
    }
}