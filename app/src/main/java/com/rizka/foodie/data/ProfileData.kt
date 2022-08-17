package com.rizka.foodie.data

import com.rizka.foodie.R

object ProfileData {

    fun generateProfileData(): List<Profile> {
        return mutableListOf(
            Profile(R.drawable.bg_rounded_purple, R.drawable.ic_outline_email, "Email", "rizkakhrnnisa28@gmail.com"),
            Profile(R.drawable.bg_rounded_purple, R.drawable.ic_outline_alt_route, "Github", "https://github.com/rizkakhrnnsa"),
            Profile(R.drawable.bg_rounded_purple, R.drawable.ic_outline_android, "Versi Aplikasi", "1.0")
        )
    }
}