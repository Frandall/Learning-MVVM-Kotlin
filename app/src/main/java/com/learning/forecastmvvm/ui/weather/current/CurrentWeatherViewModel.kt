package com.learning.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.learning.forecastmvvm.data.provider.UnitProvider
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.internal.UnitSystem
import com.learning.forecastmvvm.internal.lazyDeferred
import com.learning.forecastmvvm.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
