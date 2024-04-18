package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.category.CategoryDataSource
import com.raihan.foodstar.data.mapper.toCategories
import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.utils.ResultWrapper
import com.raihan.foodstar.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories() : Flow<ResultWrapper<List<Category>>>
}

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository{
    override fun getCategories(): Flow<ResultWrapper<List<Category>>> {
        return proceedFlow { dataSource.getCategoryData().data.toCategories() }
    }
}