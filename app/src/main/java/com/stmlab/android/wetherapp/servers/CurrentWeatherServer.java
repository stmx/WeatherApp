package com.stmlab.android.wetherapp.servers;

import com.stmlab.android.wetherapp.models.CurrentWeather;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class CurrentWeatherServer extends WeatherServer<CurrentWeather> {

    @Override
    public Observable<CurrentWeather> getWeather(String cityName) {
        return mServer.getCurrentWeatherByCity(token, cityName)
                .subscribeOn(Schedulers.io());
    }

}
