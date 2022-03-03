package com.wahyuindra.submissionfinalandroid.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Aslab(
    var image: Int = 0,
    var name: String? = "",
    var role: String? = "",
    var message: String? = ""
) : Parcelable
