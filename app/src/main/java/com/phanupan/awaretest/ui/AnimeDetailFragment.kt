package com.phanupan.awaretest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.phanupan.awaretest.R
import com.phanupan.awaretest.model.AnimeModel
import com.phanupan.awaretest.ui.view_model.AnimeDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.anime_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeDetailFragment : Fragment() {
    companion object {
        fun newInstance() = AnimeDetailFragment()
    }

    private val viewmodel: AnimeDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.anime_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        viewmodel.getAnimeDetail(activity?.intent?.getStringExtra("anime_id"))

    }

    fun initViewModel() {
        viewmodel.amime.observe(viewLifecycleOwner, animeModel)
        viewmodel.isLoading.observe(viewLifecycleOwner, loading)
    }

    private val animeModel = Observer<AnimeModel> {
        Picasso.get().load(it.image_url).into(image_title)
        tv_title?.text = "${it.title}"
        tv_description?.text = "${it.synopsis}"
    }

    private val loading = Observer<Boolean> {
        lv_loading?.visibility = if (it) View.VISIBLE else View.GONE
    }


}