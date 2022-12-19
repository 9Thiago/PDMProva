package com.example.provaconcess.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car (
    val model: String = "",
    val type: String = "",
    val price: String = "",
    var sold: Boolean = false
)  :Parcelable