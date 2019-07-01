package com.learning.forecastmvvm.data.network.response

import com.learning.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.learning.forecastmvvm.data.db.entity.WeatherLocation


data class CurrentWeatherResponse(
    val current: CurrentWeatherEntry,
    val location: WeatherLocation
)