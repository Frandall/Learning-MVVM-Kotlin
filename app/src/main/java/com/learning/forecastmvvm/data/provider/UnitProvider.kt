package com.learning.forecastmvvm.data.provider

import com.learning.forecastmvvm.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}