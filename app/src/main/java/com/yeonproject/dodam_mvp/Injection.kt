package com.yeonproject.dodam_mvp

import android.content.Context
import com.yeonproject.dodam_mvp.data.repository.my_word.MyWordRepository
import com.yeonproject.dodam_mvp.data.repository.my_word.MyWordRepositoryImpl
import com.yeonproject.dodam_mvp.data.repository.song.SongRepository
import com.yeonproject.dodam_mvp.data.repository.song.SongRepositoryImpl
import com.yeonproject.dodam_mvp.data.repository.word.WordRepository
import com.yeonproject.dodam_mvp.data.repository.word.WordRepositoryImpl
import com.yeonproject.dodam_mvp.data.room.database.MyWordDatabase
import com.yeonproject.dodam_mvp.data.source.local.my_word.MyWordLocalDataSourceImpl
import com.yeonproject.dodam_mvp.data.source.remote.song.SongRemoteDataSourceImpl
import com.yeonproject.dodam_mvp.data.source.remote.word.WordRemoteDataSourceImpl
import com.yeonproject.dodam_mvp.util.AppExecutors

object Injection {
    fun wordRepository(): WordRepository {
        return WordRepositoryImpl.getInstance(
            WordRemoteDataSourceImpl.getInstance()
        )
    }

    fun songRepository(): SongRepository {
        return SongRepositoryImpl.getInstance(
            SongRemoteDataSourceImpl.getInstance()
        )
    }

    fun myWordRepository(): MyWordRepository {
        return MyWordRepositoryImpl.getInstance(
            MyWordLocalDataSourceImpl.getInstance(
                AppExecutors(),
                MyWordDatabase.getInstance(App.instance.context())
            )
        )
    }
}