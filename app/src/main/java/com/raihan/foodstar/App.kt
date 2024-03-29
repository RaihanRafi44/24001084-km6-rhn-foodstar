package com.raihan.foodstar

import android.app.Application
import com.raihan.foodstar.data.source.local.database.AppDatabase

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        AppDatabase.getInstance(this)
    }
}