package com.raihan.foodstar.data.datasource.category

import com.raihan.foodstar.data.model.Category
import com.raihan.foodstar.data.model.Menu

class DummyCategoryDataSource : CategoryDataSource {
    override fun getCategories(): List<Category> {
        return listOf(
            Category(
                name = "Nasi",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_ricered.jpg"
            ),
            Category(
                name = "Mie",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_noodlebowl.jpg"
            ),
            Category(
                name = "Snack",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_popcorn.png"
            ),
            Category(
                name = "Ayam",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_chicken.jpg"
            ),
            Category(
                name = "Sayuran",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_soup.png"
            ),
            Category(
                name = "Minuman",
                imgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/category_img/img_drinks.jpg"
            ),
        )
    }
}