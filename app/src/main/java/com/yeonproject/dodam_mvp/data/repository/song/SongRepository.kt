package com.yeonproject.dodam_mvp.data.repository.song

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.network.model.SongResponse

interface SongRepository {
    fun getSongList(callback: Callback<List<SongResponse>>)
}