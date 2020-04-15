package com.yeonproject.dodam_mvp.data.source.remote.song

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.network.model.SongResponse

interface SongRemoteDataSource {
    fun getSongList(callback: Callback<List<SongResponse>>)
}