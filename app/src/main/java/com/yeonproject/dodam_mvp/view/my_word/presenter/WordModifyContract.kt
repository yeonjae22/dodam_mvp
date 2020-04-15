package com.yeonproject.dodam_mvp.view.my_word.presenter

import com.yeonproject.dodam_mvp.data.room.entity.MyWordEntity

interface WordModifyContract {

    interface View {
        var presenter: Presenter
        fun showMyWord(response: MyWordEntity)
        fun showModifyResult(response: Boolean)
    }

    interface Presenter {
        fun getMyWord(wordNumber: Int)
        fun updateMyWord(wordNumber: Int, hangul: String, english: String, image: String)
    }
}