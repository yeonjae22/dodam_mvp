package com.yeonproject.dodam_mvp.view.word.presenter

import com.yeonproject.dodam_mvp.data.model.WordItem
import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.data.repository.word.WordRepository
import com.yeonproject.dodam_mvp.network.model.WordResponse

class WordPresenter(
    private val repository: WordRepository,
    private val view: WordContract.View
) : WordContract.Presenter {
    override fun getWordList(theme: String, language: String) {
        repository.getWordList(theme, object : Callback<List<WordResponse>> {
            override fun onSuccess(response: List<WordResponse>) {
                val items = mutableListOf<WordItem>()
                for (i in response.indices) {
                    items.add(response[i].toWordItem(response[i], language))
                }
                view.showWordList(items)
            }

            override fun onFailure(message: String) {

            }
        })
    }
}