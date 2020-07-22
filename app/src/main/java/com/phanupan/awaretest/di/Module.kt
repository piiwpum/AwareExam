package com.phanupan.awaretest.di

import com.phanupan.awaretest.data.NetworkClient
import com.phanupan.awaretest.repo.AnimeRepository
import com.phanupan.awaretest.ui.view_model.AnimeDetailViewModel
import com.phanupan.awaretest.ui.view_model.AnimeListViewModel
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClient() }
    single { AnimeRepository(get()) }
}

val appModule = module {
    single { AnimeListViewModel(get()) }
    factory { AnimeDetailViewModel(get()) }
}