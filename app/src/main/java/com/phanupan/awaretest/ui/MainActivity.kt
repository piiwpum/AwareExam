package com.phanupan.awaretest.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.phanupan.awaretest.R
import com.phanupan.awaretest.model.AnimeModel
import com.phanupan.awaretest.ui.adapter.AnimeListAdapter
import com.phanupan.awaretest.ui.view_model.AnimeListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewmodel: AnimeListViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()


    }

    fun initViewModel() {
        viewmodel.amimeLs.observe(this, animeLs)
        viewmodel.isLoading.observe(this, loading)
    }


    private val animeLs = Observer<AnimeModel> {
        rv_anime?.layoutManager = LinearLayoutManager(this)
        rv_anime?.adapter = AnimeListAdapter(this, it.top)
    }

    private val loading = Observer<Boolean> {
        lv_loading?.visibility = if (it) View.VISIBLE else View.GONE
    }
}