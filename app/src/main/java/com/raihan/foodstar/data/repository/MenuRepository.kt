package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.menu.MenuDataSource
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.mapper.toMenus
import com.raihan.foodstar.utils.ResultWrapper
import com.raihan.foodstar.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getMenus(categorySlug : String? = null) : Flow<ResultWrapper<List<Menu>>>
}

class MenuRepositoryImpl(private val dataSource: MenuDataSource) : MenuRepository {
    override fun getMenus(categorySlug: String?): Flow<ResultWrapper<List<Menu>>> {
        return proceedFlow {
            dataSource.getMenuData(categorySlug).data.toMenus()
        }
    }
}