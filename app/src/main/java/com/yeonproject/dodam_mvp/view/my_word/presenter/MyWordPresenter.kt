package com.yeonproject.dodam_mvp.view.my_word.presenter

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.data.repository.my_word.MyWordRepository
import com.yeonproject.dodam_mvp.data.room.entity.MyWordEntity

class MyWordPresenter(
    private val repository: MyWordRepository,
    private val view: MyWordContract.View
) : MyWordContract.Presenter {
    override fun getMyWordList() {
        repository.getMyWord(object : Callback<List<MyWordEntity>> {
            override fun onSuccess(response: List<MyWordEntity>) {
                view.showMyWordList(response)
            }

            override fun onFailure(message: String) {

            }

        })
    }
}