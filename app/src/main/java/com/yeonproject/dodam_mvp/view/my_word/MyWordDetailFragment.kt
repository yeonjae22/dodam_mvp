package com.yeonproject.dodam_mvp.view.my_word

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yeonproject.dodam_mvp.R
import com.yeonproject.dodam_mvp.ext.glideImageSet
import com.yeonproject.dodam_mvp.view.word.WordPaint
import kotlinx.android.synthetic.main.fragment_my_word_detail.*

class MyWordDetailFragment : Fragment() {
    private val dispatcher by lazy {
        requireActivity().onBackPressedDispatcher
    }
    private lateinit var listener: OnClickListener

    interface OnClickListener {
        fun onClick(fragment: Fragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = (context as OnClickListener)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_my_word_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var myPaint = WordPaint(context)
        linear.addView(myPaint)

        tv_name.text = arguments?.getString(NAME)
        val image =
            context?.filesDir?.absoluteFile.toString() + "/" + arguments?.getString(IMAGE) ?: ""
        iv_image.glideImageSet(image, iv_image.measuredWidth, iv_image.measuredHeight)

        btn_back.setOnClickListener {
            dispatcher.onBackPressed()
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
            myPaint = WordPaint(context)
            linear.addView(myPaint)
        }
    }

    companion object {
        private const val NAME = "name"
        private const val IMAGE = "image"
        fun newInstance(name: String, image: String) = MyWordDetailFragment().apply {
            arguments = Bundle().apply {
                putString(NAME, name)
                putString(IMAGE, image)
            }
        }
    }
}