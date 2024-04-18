package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.source.network.model.menu.MenusResponse
import com.raihan.foodstar.data.source.network.services.FoodStarApiService

class MenuApiDataSource (private val service : FoodStarApiService): MenuDataSource {
    override suspend fun getMenuData(categorySlug: String?): MenusResponse {
        return service.getMenus(categorySlug)
    }

}