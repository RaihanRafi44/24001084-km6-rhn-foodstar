package com.raihan.foodstar.data.mapper

import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.source.network.model.category.CategoryItemResponse

fun CategoryItemResponse?.toCategory() = Category(
    imgUrl = this?.imageUrl.orEmpty(),
    name = this?.nama.orEmpty()
)

fun Collection<CategoryItemResponse>?.toCategories() = this?.map { it.toCategory() } ?: listOf()