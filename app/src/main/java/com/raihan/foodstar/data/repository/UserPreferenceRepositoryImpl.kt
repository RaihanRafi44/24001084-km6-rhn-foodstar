package com.raihan.foodstar.data.repository

import com.raihan.foodstar.data.datasource.pref.UserPreference

class UserPreferenceRepositoryImpl(private val dataSource: UserPreference) : UserPreferenceRepository {
    override fun isUsingGridMode(): Boolean {
        return dataSource.isUsingGridMode()
    }

    override fun setUsingGridMode(isUsingGridMode: Boolean) {
        dataSource.setUsingGridMode(isUsingGridMode)
    }
}
