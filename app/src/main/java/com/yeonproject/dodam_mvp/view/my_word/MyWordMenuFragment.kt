package com.yeonproject.dodam_mvp.view.my_word

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yeonproject.dodam_mvp.R
import com.yeonproject.dodam_mvp.view.intro.LanguageFragment
import kotlinx.android.synthetic.main.fragment_my_word_menu.*

class MyWordMenuFragment : Fragment() {
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
    ): View? = inflater.inflate(R.layout.fragment_my_word_menu, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_back.setOnClickListener {
            dispatcher.onBackPressed()
        }

        btn_register.setOnClickListener {
            listener.onClick(WordRegisterFragment())
        }

        btn_modify.setOnClickListener {
            listener.onClick(MyWordListFragment())
        }

        btn_learning.setOnClickListener {
            listener.onClick(MyWordLanguageFragment())
        }
    }
}