package com.raihan.foodstar.data.datasource.category

import com.raihan.foodstar.data.source.network.model.category.CategoriesResponse

interface CategoryDataSource {
    suspend fun getCategoryData(): CategoriesResponse
}