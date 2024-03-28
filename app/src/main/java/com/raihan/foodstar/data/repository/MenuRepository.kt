package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.menu.MenuDataSource
import com.raihan.foodstar.data.model.Menu

interface MenuRepository {
    fun getMenus() : List<Menu>
}

class MenuRepositoryImpl(private val dataSource: MenuDataSource) : MenuRepository {
    override fun getMenus(): List<Menu> = dataSource.getMenus()
}