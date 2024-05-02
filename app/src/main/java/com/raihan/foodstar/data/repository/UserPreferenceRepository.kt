package com.raihan.foodstar.data.repository

interface UserPreferenceRepository {
    fun isUsingGridMode(): Boolean

    fun setUsingGridMode(isUsingGridMode: Boolean)
}
