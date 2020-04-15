package com.yeonproject.dodam_mvp.data.source.remote.word

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.network.model.WordResponse

interface WordRemoteDataSource {
    fun getWordList(theme: String, callback: Callback<List<WordResponse>>)
}