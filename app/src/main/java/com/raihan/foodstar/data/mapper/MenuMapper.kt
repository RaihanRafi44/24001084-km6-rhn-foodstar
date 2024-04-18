package com.raihan.foodstar.data.mapper

import com.raihan.foodstar.data.model.Menu
import com.raihan.foodstar.data.source.network.model.menu.MenuItemResponse

fun MenuItemResponse?.toMenu() = Menu(
    imgUrl = this?.imageUrl.orEmpty(),
    name = this?.nama.orEmpty(),
    desc = this?.detail.orEmpty(),
    address = this?.alamatResto.orEmpty(),
    addressUrl = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77",
    price = (this?.harga ?: 0).toDouble(),
)

fun Collection<MenuItemResponse>?.toMenus() = this?.map {
    it.toMenu()
} ?: listOf()