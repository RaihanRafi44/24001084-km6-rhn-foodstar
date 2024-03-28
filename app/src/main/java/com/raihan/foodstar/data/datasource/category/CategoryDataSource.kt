package com.raihan.foodstar.data.datasource.category

import com.raihan.foodstar.data.model.Category

interface CategoryDataSource {
    fun getCategories(): List<Category>
}