package com.learning.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.learning.forecastmvvm.data.db.entity.WeatherLocation
import com.learning.forecastmvvm.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}