package com.learning.forecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import com.learning.forecastmvvm.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("alert")
                                 val alert: Alert,
    @SerializedName("location")
                                 val location: WeatherLocation,
    @SerializedName("forecast")
                                 val futureWeatherEntries: ForecastDaysContainer)