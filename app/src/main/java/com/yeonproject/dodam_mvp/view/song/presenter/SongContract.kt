package com.yeonproject.dodam_mvp.view.song.presenter

import com.yeonproject.dodam_mvp.network.model.SongResponse

interface SongContract {

    interface View {
        var presenter: Presenter
        fun showSongList(items: List<SongResponse>)
    }

    interface Presenter {
        fun getSongList()
    }
}