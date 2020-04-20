package com.yeonproject.dodam_mvp.view.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yeonproject.dodam_mvp.R

class HomeActivity : AppCompatActivity(), HomeFragment.OnClickListener,
    LanguageFragment.OnClickListener, ThemeFragment.OnClickListener {
    override fun onClick() {
        back()
    }

    override fun onClick(fragment: Fragment) {
        replace(fragment, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replace(HomeFragment(), false)
    }

    private fun replace(fragment: Fragment, isBackStack: Boolean = true) {
        if (isBackStack) {
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment)
                .addToBackStack(null).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment)
                .commit()

        }
    }

    private fun back() {
        supportFragmentManager.popBackStack()
    }
}
