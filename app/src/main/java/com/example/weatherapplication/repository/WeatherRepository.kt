package com.example.weatherapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.entity.entity.Hourly
import com.example.weatherapplication.data.entity.entity.WeatherResponse
import com.example.weatherapplication.data.entity.lds.LocalDataSource
import com.example.weatherapplication.data.entity.rds.RemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow

class WeatherRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) :
    WeatherInterface {
    suspend fun getWeatherCurrent() = remoteDataSource.getWeatherCurrent()
    suspend fun getWeatherWeekly() = remoteDataSource.getWeatherWeekly()
    override fun getCurrentConditions(): MutableLiveData<WeatherResponse?> = localDataSource.dayData
    override fun getWeeklyConditions(): MutableStateFlow<WeatherResponse?> = localDataSource.weekData
    override fun getHourlyConditions(): MutableStateFlow<Hourly?> = localDataSource.hourlyData
    }

