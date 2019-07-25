package com.learning.forecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import com.learning.forecastmvvm.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(@SerializedName("forecastday")
                    val entries: List<FutureWeatherEntry>)