package com.yeonproject.dodam_mvp.view.song

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeonproject.dodam_mvp.Injection
import com.yeonproject.dodam_mvp.R
import com.yeonproject.dodam_mvp.network.model.SongResponse
import com.yeonproject.dodam_mvp.view.song.adapter.SongAdapter
import com.yeonproject.dodam_mvp.view.song.presenter.SongContract
import com.yeonproject.dodam_mvp.view.song.presenter.SongPresenter
import kotlinx.android.synthetic.main.activity_song_list.*

class SongListActivity : AppCompatActivity(), SongContract.View {
    override lateinit var presenter: SongContract.Presenter
    private var songAdapter = SongAdapter()

    override fun showSongList(items: List<SongResponse>) {
        songAdapter.addData(items)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)
        presenter = SongPresenter(
            Injection.songRepository(), this
        )
        presenter.getSongList()

        btn_back.setOnClickListener {
            finish()
        }

        rv_song_list?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = songAdapter
        }

        songAdapter.setOnClickListener(object :
            SongAdapter.OnClickListener {
            override fun onClick(song: SongResponse) {
                val intent = Intent(applicationContext, SongDetailActivity::class.java)
                intent.putExtra(ID, song.id)
                intent.putExtra(NAME, song.name)
                startActivity(intent)
            }
        })
    }

    companion object {
        private const val ID = "id"
        private const val NAME = "name"
    }
}
