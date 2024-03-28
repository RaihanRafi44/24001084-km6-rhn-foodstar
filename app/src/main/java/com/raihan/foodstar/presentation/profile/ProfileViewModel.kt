package com.raihan.foodstar.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raihan.foodstar.data.model.Profile

class ProfileViewModel : ViewModel() {
    val profileData = MutableLiveData(
        Profile(
            username = "Raihan Rafi Rizqullah",
            email = "raihanrrizqullah@gmail.com",
            profileImgUrl = "https://raw.githubusercontent.com/RaihanRafi44/foodstar-assets/main/profile/img_profile.jpg",
            phoneNumber = "0895397833055"
        )
    )

    val isEditMode = MutableLiveData(false)

    fun changeEditMode() {
        val currentValue = isEditMode.value ?: false
        isEditMode.postValue(!currentValue)
    }
}