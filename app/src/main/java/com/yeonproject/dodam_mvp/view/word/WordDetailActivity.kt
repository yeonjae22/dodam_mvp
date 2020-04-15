package com.yeonproject.dodam_mvp.view.word

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yeonproject.dodam_mvp.R
import com.yeonproject.dodam_mvp.ext.glideImageSet
import kotlinx.android.synthetic.main.activity_word_detail.*

class WordDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_detail)
        var myPaint = WordPaint(this)
        linear.addView(myPaint)

        tv_name.text = intent.getStringExtra(NAME).toLowerCase()
        iv_image.glideImageSet(
            intent.getStringExtra(IMAGE),
            iv_image.measuredWidth,
            iv_image.measuredHeight
        )

        btn_back.setOnClickListener {
            finish()
        }

        btn_red.setOnClickListener {
            myPaint.setColor(Color.RED)
        }

        btn_blue.setOnClickListener {
            myPaint.setColor(Color.BLUE)
        }

        btn_black.setOnClickListener {
            myPaint.setColor(Color.BLACK)
        }

        btn_eraser.setOnClickListener {
            linear.removeAllViews()
            myPaint = WordPaint(this)
            linear.addView(myPaint)
        }
    }

    companion object {
        private const val NAME = "name"
        private const val IMAGE = "image"
    }
}