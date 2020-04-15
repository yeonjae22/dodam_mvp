package com.yeonproject.dodam_mvp.data.model

import java.io.Serializable

data class WordItem(
    val name: String = "",
    val image: String = "",
    val sound: String = ""
) : Serializable