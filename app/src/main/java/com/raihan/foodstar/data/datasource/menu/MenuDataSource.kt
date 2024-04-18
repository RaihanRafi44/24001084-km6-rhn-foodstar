package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.source.network.model.menu.MenusResponse

interface MenuDataSource {
    suspend fun getMenuData(categorySlug: String? = null): MenusResponse
}