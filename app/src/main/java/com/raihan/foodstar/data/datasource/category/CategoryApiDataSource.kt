package com.raihan.foodstar.data.datasource.category

import com.raihan.foodstar.data.source.network.model.category.CategoriesResponse
import com.raihan.foodstar.data.source.network.services.FoodStarApiService

class CategoryApiDataSource (private val service: FoodStarApiService) : CategoryDataSource {
    override suspend fun getCategoryData(): CategoriesResponse {
        return service.getCategories()
    }

}