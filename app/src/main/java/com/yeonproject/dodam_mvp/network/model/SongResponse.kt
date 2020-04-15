package com.yeonproject.dodam_mvp.network.model

import java.io.Serializable

data class SongResponse constructor(
    val name: String = "",
    val id: String = "",
    val image: String = ""
) : Serializable