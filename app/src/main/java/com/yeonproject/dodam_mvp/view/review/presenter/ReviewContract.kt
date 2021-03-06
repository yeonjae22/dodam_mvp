package com.yeonproject.dodam_mvp.view.review.presenter

import com.yeonproject.dodam_mvp.data.model.WordItem

interface ReviewContract {

    interface View {
        var presenter: Presenter
        fun showWordList(items: List<WordItem>)
    }

    interface Presenter {
        fun wordList(theme: String, language: String)
    }
}