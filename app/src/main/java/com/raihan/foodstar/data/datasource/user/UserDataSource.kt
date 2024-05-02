package com.raihan.foodstar.data.datasource.user

import com.raihan.foodstar.data.model.Profile

interface UserDataSource {
    fun getData(): List<Profile>
}
