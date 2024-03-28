package com.raihan.foodstar.presentation.home

import androidx.lifecycle.ViewModel
import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.repository.CategoryRepository
import com.raihan.foodstar.data.repository.MenuRepository

/*
class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val menuRepository: MenuRepository
) : ViewModel() {

    fun getMenus(): List<Menu> {
        return menuRepository.getMenus()
    }

    fun getCategories(): List<Category> {
        return categoryRepository.getCategories()
    }
}*/

class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val menuRepository: MenuRepository
) : ViewModel() {

    fun getMenus() = menuRepository.getMenus()
    fun getCategories() = categoryRepository.getCategories()

}
