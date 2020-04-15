package com.yeonproject.dodam_mvp.data.repository.word

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.network.model.WordResponse

interface WordRepository {
    fun getWordList(theme: String, callback: Callback<List<WordResponse>>)
}