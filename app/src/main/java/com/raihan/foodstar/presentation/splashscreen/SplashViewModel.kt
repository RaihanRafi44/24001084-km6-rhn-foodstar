package com.raihan.foodstar.presentation.splashscreen

import androidx.lifecycle.ViewModel
import com.raihan.foodstar.data.repository.UserRepository

class SplashViewModel(private val repository: UserRepository) : ViewModel() {
    fun isUserLoggedIn() = repository.isLoggedIn()
}
