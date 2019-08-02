package com.learning.forecastmvvm.ui.weather.future.detail

import androidx.lifecycle.ViewModel;
import com.learning.forecastmvvm.data.provider.UnitProvider
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.internal.lazyDeferred
import com.learning.forecastmvvm.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred{
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}
