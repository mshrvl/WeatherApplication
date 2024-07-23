package com.example.weatherapplication

import com.example.weatherapplication.data.entity.lds.LocalDataSource
import com.example.weatherapplication.data.entity.rds.RemoteDataSource

class MyRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource){

}