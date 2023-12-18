package com.saddict.birthdayapp.navigation

import androidx.annotation.StringRes
import com.saddict.birthdayapp.R

enum class BdNavEnum(@StringRes val title: Int) {
    Start(title = R.string.hb),
    Message(title = R.string.congrats)
}