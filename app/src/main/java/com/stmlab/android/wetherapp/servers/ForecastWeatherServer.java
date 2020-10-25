package com.stmlab.android.wetherapp.servers;

import com.stmlab.android.wetherapp.models.ForecastWeather;

import io.reactivex.Observable;

public class ForecastWeatherServer extends WeatherServer<ForecastWeather> {
    @Override
    public Observable<ForecastWeather> getWeather(String cityName) {
        return mServer.getForecastWeatherByCity(token, cityName);
    }
}
