package com.yeonproject.dodam_mvp.network.model

import com.yeonproject.dodam_mvp.data.model.WordItem
import java.io.Serializable

data class WordResponse @JvmOverloads constructor(
    val english: String = "",
    val hangul: String = "",
    val image: String = "",
    val sound: String = ""
) : Serializable {
    fun toWordItem(response: WordResponse, language: String): WordItem {
        var name = ""
        if (language == "english") {
            name = response.english
        } else if (language == "hangul") {
            name = response.hangul
        }
        return WordItem(
            name,
            response.image,
            response.sound
        )
    }
}