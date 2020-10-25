package com.stmlab.android.wetherapp.servers;

import com.stmlab.android.wetherapp.models.CurrentWeather;
import com.stmlab.android.wetherapp.models.ForecastWeather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface CurrentWeatherAPI {
    @GET("weather?units=metric&lang=ru")
    Observable<CurrentWeather> getCurrentWeatherByCity(@Query("appid") String token, @Query("q") String cityName);

    @GET("forecast?units=metric&lang=ru")
    Observable<ForecastWeather> getForecastWeatherByCity(@Query("appid") String token, @Query("q") String cityName);
}
