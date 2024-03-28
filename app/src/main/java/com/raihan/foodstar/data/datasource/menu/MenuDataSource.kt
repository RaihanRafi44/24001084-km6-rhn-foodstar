package com.raihan.foodstar.data.datasource.menu

import com.raihan.foodstar.data.model.Menu

interface MenuDataSource {
    fun getMenus(): List<Menu>
}