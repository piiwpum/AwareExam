package com.phanupan.awaretest.data

import com.phanupan.awaretest.model.AnimeModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
    @GET("/v3/top/anime/1")
    fun getAnimeLs(): Flowable<AnimeModel>

    @GET("/v3/anime/{id}")
    fun getAnimeDetail(@Path("id") id: String): Flowable<AnimeModel>

}