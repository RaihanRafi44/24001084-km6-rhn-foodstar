package com.raihan.foodstar.presentation.main

import androidx.lifecycle.ViewModel
import com.raihan.foodstar.data.repository.UserRepository

class MainViewModel (
    private val userRepository: UserRepository
    ) : ViewModel(){
        fun isLoggedIn() =
            userRepository
                .isLoggedIn()
}
