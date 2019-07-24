package com.learning.forecastmvvm.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learning.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.learning.forecastmvvm.data.network.response.FutureWeatherResponse
import com.learning.forecastmvvm.internal.NoConnectivityException

const val FORECAST_DAYS_COUNT = 7

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchedCurrentWeather = apixuWeatherApiService.getCurrentWeather(location, languageCode)
            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        }catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection.", e)
        }
    }

    private val _downloadFutureWeather = MutableLiveData<FutureWeatherResponse>()

    override val downloadedFutureWeather: LiveData<FutureWeatherResponse>
        get() = _downloadFutureWeather

    override suspend fun fetchFutureWeather(location: String, languageCode: String) {
        try {
            val fetchedFutureWeather = apixuWeatherApiService.getFutureWeather(location, FORECAST_DAYS_COUNT, languageCode)
            _downloadFutureWeather.postValue(fetchedFutureWeather)
        }catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection.", e)
        }
    }

}