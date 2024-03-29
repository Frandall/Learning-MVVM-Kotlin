package com.learning.forecastmvvm.data.db.entity

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import com.learning.forecastmvvm.data.db.entity.Condition

data class Day(@SerializedName("avgvis_km")
               val avgvisKm: Double = 0.0,
               @SerializedName("uv")
               val uv: Double = 0.0,
               @SerializedName("avgtemp_f")
               val avgtempF: Double = 0.0,
               @SerializedName("avgtemp_c")
               val avgtempC: Double = 0.0,
               @SerializedName("maxtemp_c")
               val maxtempC: Double = 0.0,
               @SerializedName("maxtemp_f")
               val maxtempF: Double = 0.0,
               @SerializedName("mintemp_c")
               val mintempC: Double = 0.0,
               @SerializedName("avgvis_miles")
               val avgvisMiles: Double = 0.0,
               @SerializedName("mintemp_f")
               val mintempF: Double = 0.0,
               @SerializedName("totalprecip_in")
               val totalprecipIn: Double = 0.0,
               @Embedded(prefix = "condition_")
               @SerializedName("condition")
               val condition: Condition,
               @SerializedName("maxwind_kph")
               val maxwindKph: Double = 0.0,
               @SerializedName("maxwind_mph")
               val maxwindMph: Double = 0.0,
               @SerializedName("totalprecip_mm")
               val totalprecipMm: Double = 0.0)