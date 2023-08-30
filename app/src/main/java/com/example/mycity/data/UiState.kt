package com.example.mycity.data

import androidx.annotation.DrawableRes
import com.example.mycity.R

data class UiState(
    val name: String = "",
    val city: String = "",
    @DrawableRes val image: Int = R.drawable.pic1,
    @DrawableRes val cityImage: Int = R.drawable.pic2,
    val description: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. I"
)
