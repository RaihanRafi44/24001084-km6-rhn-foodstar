package com.raihan.foodstar.data.model

import java.util.UUID

data class Profile(
    var id: String = UUID.randomUUID().toString(),
    val username: String,
    val email: String,
    val profileImgUrl: String,
)
