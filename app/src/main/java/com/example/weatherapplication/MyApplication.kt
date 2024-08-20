package com.example.weatherapplication

import android.app.Application
import com.example.weatherapplication.data.entity.lds.LocalDataSource
import com.example.weatherapplication.data.entity.rds.RemoteDataSource
import com.example.weatherapplication.data.entity.rds.WeatherApi
import com.example.weatherapplication.screens.firstscreen.ViewModelFirstScreen
import com.example.weatherapplication.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    factory { get<Retrofit>().create(WeatherApi::class.java) }
    single { LocalDataSource(context = androidContext()) }
    factoryOf(::WeatherRepository)
    factoryOf(::RemoteDataSource)

    single {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

val presentationModule = module {
    viewModelOf(::ViewModelFirstScreen)
}

class MyApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(dataModule, presentationModule))
        }
    }
}