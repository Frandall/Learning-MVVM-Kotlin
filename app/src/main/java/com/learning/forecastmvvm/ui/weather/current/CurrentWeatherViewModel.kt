package com.learning.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.internal.UnitSystem
import com.learning.forecastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC
    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC
    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
