package com.learning.forecastmvvm.internal

import java.io.IOError
import java.io.IOException
import java.lang.Exception

class NoConnectivityException : IOException()
class LocationPermissionNotGrantedException : Exception()
class DateNotFoundException: Exception()