package com.yeonproject.dodam_mvp.data.repository.song

import com.yeonproject.dodam_mvp.data.repository.Callback
import com.yeonproject.dodam_mvp.data.source.remote.song.SongRemoteDataSource
import com.yeonproject.dodam_mvp.network.model.SongResponse

class SongRepositoryImpl private constructor(private val remoteDataSource: SongRemoteDataSource) :
    SongRepository {
    override fun getSongList(callback: Callback<List<SongResponse>>) {
        remoteDataSource.getSongList(callback)
    }

    companion object {
        fun getInstance(remoteDataSource: SongRemoteDataSource): SongRepository =
            SongRepositoryImpl(remoteDataSource)
    }
}