package com.raihan.foodstar.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.raihan.foodstar.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers

class RegisterViewModel(private val repository: UserRepository) : ViewModel() {

    fun doRegister(email : String, fullName : String, password : String) =
        repository
            .doRegister(email, fullName, password)
            .asLiveData(Dispatchers.IO)
}