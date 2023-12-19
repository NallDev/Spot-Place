package com.nalldev.spotplace

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://weather-api-tau-six.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

    viewModel {
        MainViewModel(get())
    }
}