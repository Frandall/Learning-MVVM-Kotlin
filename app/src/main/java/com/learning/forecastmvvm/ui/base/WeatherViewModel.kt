package com.learning.forecastmvvm.ui.base

import androidx.lifecycle.ViewModel
import com.learning.forecastmvvm.data.provider.UnitProvider
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.internal.UnitSystem
import com.learning.forecastmvvm.internal.lazyDeferred

abstract class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}