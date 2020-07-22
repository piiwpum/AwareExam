package com.phanupan.awaretest.model

import com.google.gson.annotations.SerializedName


data class AnimeModel(
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int,
    @SerializedName("request_cached")
    val requestCached: Boolean,
    @SerializedName("request_hash")
    val requestHash: String,
    @SerializedName("top")
    val top: MutableList<Top>,
    @SerializedName("title")
    val title: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("image_url")
    val image_url: String
)

data class Top(
    @SerializedName("end_date")
    val endDate: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("members")
    val members: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("score")
    val score: Double,
    @SerializedName("start_date")
    val startDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)