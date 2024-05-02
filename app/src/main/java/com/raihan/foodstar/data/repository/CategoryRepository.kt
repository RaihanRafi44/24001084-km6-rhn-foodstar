package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getCategories(): Flow<ResultWrapper<List<Category>>>
}
