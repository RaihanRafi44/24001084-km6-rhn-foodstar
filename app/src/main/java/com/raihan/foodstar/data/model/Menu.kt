package com.raihan.foodstar.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Menu(
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var imgUrl: String,
    var price: Double,
    var desc: String,
    var address: String,
    var addressUrl: String
) : Parcelable
