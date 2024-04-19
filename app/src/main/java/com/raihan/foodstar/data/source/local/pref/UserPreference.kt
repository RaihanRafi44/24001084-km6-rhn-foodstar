package com.raihan.foodstar.data.source.local.pref

import android.content.Context
import com.raihan.foodstar.utils.SharedPreferenceUtils
import com.raihan.foodstar.utils.SharedPreferenceUtils.set

interface UserPreference {
    fun isUsingGridMode(): Boolean
    fun setUsingGridMode(isUsingGridMode: Boolean)

}

class UserPreferenceImpl(private val context : Context) : UserPreference {
    private val pref = SharedPreferenceUtils.createPreference(context, PREF_NAME)
    override fun isUsingGridMode(): Boolean = pref.getBoolean(KEY_IS_USING_GRID_MODE, false)

    override fun setUsingGridMode(isUsingGridMode: Boolean) {
        pref[KEY_IS_USING_GRID_MODE] = isUsingGridMode
    }

    companion object{
        const val PREF_NAME = "foodstar-pref"
        const val KEY_IS_USING_GRID_MODE = "KEY_IS_USING_GRID_MODE"
    }
}