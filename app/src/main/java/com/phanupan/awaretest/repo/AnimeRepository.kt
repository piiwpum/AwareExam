package com.phanupan.awaretest.repo

import com.phanupan.awaretest.data.AnimeService
import com.phanupan.awaretest.data.NetworkClient
import com.phanupan.awaretest.model.AnimeModel
import io.reactivex.Flowable

class AnimeRepository constructor(private val networkClient: NetworkClient) : AnimeService {

    override fun getAnimeLs(): Flowable<AnimeModel> {
        return networkClient.getService().getAnimeLs()
    }

    override fun getAnimeDetail(id: String): Flowable<AnimeModel> {
        return networkClient.getService().getAnimeDetail(id)
    }
}