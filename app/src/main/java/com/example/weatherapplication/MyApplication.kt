package com.example.weatherapplication

import com.example.weatherapplication.data.entity.rds.WeatherApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single { get<Retrofit>().create(WeatherApi::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}