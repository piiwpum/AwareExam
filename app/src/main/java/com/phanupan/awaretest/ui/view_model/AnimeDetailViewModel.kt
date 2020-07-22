package com.phanupan.awaretest.ui.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phanupan.awaretest.model.AnimeModel
import com.phanupan.awaretest.repo.AnimeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeDetailViewModel constructor(private val repo: AnimeRepository) : ViewModel() {
    private val _anime: MutableLiveData<AnimeModel> = MutableLiveData()
    var amime: LiveData<AnimeModel> = _anime

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var isLoading: LiveData<Boolean> = _isLoading


    fun getAnimeDetail(id: String?) {
        _isLoading.value = true
        if (id != null) {
            repo.getAnimeDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    _isLoading.value = false
                    _anime.value = it
                }, { t ->
                })
        }
    }


}