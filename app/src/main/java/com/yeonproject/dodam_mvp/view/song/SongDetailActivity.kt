package com.yeonproject.dodam_mvp.view.song

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yeonproject.dodam_mvp.R
import kotlinx.android.synthetic.main.activity_song_detail.*

class SongDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)
        val id = intent.getStringExtra(ID)
        val name = intent.getStringExtra(NAME)

        tv_name.text = name
        tv_link.text = "www.youtube.com/watch?v=$id"
        val youTubePlayerView = you_tube_player_view
        if (id != null) {
            youTubePlayerView.play(id)
        }

        btn_back.setOnClickListener {
            finish()
        }
    }

    companion object {
        private const val ID = "id"
        private const val NAME = "name"
    }
}