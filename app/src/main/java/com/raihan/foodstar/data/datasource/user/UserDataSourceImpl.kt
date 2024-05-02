package com.raihan.foodstar.data.datasource.user

import com.raihan.foodstar.data.model.Profile

class UserDataSourceImpl : UserDataSource {
    override fun getData(): List<Profile> {
        return listOf(
            Profile(
                username = "Raihan Rafi Rizqullah",
                email = "raihanrrizqullah@gmail.com",
                profileImgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/profile/img_profile.jpg",
            ),
        )
    }
}
