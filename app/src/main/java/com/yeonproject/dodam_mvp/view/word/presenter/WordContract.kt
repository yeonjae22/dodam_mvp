package com.yeonproject.dodam_mvp.view.word.presenter

import com.yeonproject.dodam_mvp.data.model.WordItem

interface WordContract {

    interface View {
        var presenter: Presenter
        fun showWordList(items: List<WordItem>)
    }

    interface Presenter {
        fun getWordList(theme: String, language: String)
    }
}