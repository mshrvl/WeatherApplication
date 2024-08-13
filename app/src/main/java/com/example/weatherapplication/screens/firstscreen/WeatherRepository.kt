package com.example.weatherapplication.screens.firstscreen

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import com.example.weatherapplication.data.entity.lds.LocalDataSource
import com.example.weatherapplication.data.entity.rds.RemoteDataSource

class WeatherRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) :
    WeatherInterface {
    suspend fun getWeatherCurrent() = remoteDataSource.getWeatherCurrent()
    override fun getCurrentConditions(): MutableLiveData<WeatherResponse?> = localDataSource.dayData
}
