package com.yeonproject.dodam_mvp.view.my_word.presenter

interface WordRegisterContract {

    interface View {
        var presenter: Presenter
        fun showMessage(response: Boolean)
    }

    interface Presenter {
        fun createMyWord(wordNumber: Int, hangul: String, english: String, image: String)
    }
}