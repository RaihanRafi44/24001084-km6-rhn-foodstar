package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.category.CategoryDataSource
import com.raihan.foodstar.data.model.Category

interface CategoryRepository {
    fun getCategories() : List<Category>
}

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository{
    override fun getCategories(): List<Category> = dataSource.getCategories()
}