package com.learning.forecastmvvm

import android.app.Application
import android.preference.Preference
import android.preference.PreferenceManager
import com.jakewharton.threetenabp.AndroidThreeTen
import com.learning.forecastmvvm.data.db.ForecastDatabase
import com.learning.forecastmvvm.data.network.*
import com.learning.forecastmvvm.data.provider.LocationProvider
import com.learning.forecastmvvm.data.provider.LocationProviderImpl
import com.learning.forecastmvvm.data.provider.UnitProvider
import com.learning.forecastmvvm.data.provider.UnitProviderImpl
import com.learning.forecastmvvm.data.repository.ForecastRepository
import com.learning.forecastmvvm.data.repository.ForecastRepositoryImpl
import com.learning.forecastmvvm.ui.weather.current.CurrentWeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl()}
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false )
    }
}