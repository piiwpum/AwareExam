package com.phanupan.awaretest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.phanupan.awaretest.R

class AnimeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anime_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AnimeDetailFragment.newInstance()).commit()
        }
    }
}