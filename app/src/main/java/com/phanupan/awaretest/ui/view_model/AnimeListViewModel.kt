package com.phanupan.awaretest.ui.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phanupan.awaretest.model.AnimeModel
import com.phanupan.awaretest.repo.AnimeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeListViewModel constructor(private val repo: AnimeRepository) : ViewModel() {
    private val _animeLs: MutableLiveData<AnimeModel> = MutableLiveData()
    var amimeLs: LiveData<AnimeModel> = _animeLs

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var isLoading: LiveData<Boolean> = _isLoading

    init {
        featchData()
    }

    fun featchData() {
        _isLoading.value = true
        repo.getAnimeLs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("load_error", "error = ${it.requestHash}")
                _isLoading.value = false
                _animeLs.value = it
            }, { t: Throwable? ->
                Log.d("load_error", "error = ${t?.message}")
            })

    }

}