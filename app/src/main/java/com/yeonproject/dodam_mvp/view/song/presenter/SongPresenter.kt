package com.yeonproject.dodam_mvp.view.song.presenter

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.data.repository.song.SongRepository
import com.yeonproject.dodam_mvp.network.model.SongResponse

class SongPresenter(
    private val repository: SongRepository,
    private val view: SongContract.View
) : SongContract.Presenter {
    override fun getSongList() {
        repository.getSongList(object : Callback<List<SongResponse>> {
            override fun onSuccess(response: List<SongResponse>) {
                view.showSongList(response)
            }

            override fun onFailure(message: String) {

            }

        })
    }
}