package com.learning.forecastmvvm.ui.weather.future.list

import androidx.lifecycle.ViewModel;
import com.learning.forecastmvvm.data.provider.UnitProvider
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.internal.lazyDeferred
import com.learning.forecastmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    private val unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {
    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}
