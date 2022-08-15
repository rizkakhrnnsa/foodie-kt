package com.rizka.foodie.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Foodie(
    var imageFoodie: String = "",
    var nameFoodie: String = "",
    var descriptionFoodie: String = "",
    var countryOriginFoodie: String = ""
): Parcelable
