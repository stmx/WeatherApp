package com.stmlab.android.wetherapp.servers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class WeatherServer<T> {
    protected final String token = "b909dccdbb2d659269be01c00c1bf99f";
    //    protected final String token = "0794e287eb086074a3903be8bce6cb25";
    CurrentWeatherAPI mServer;

    abstract public Observable<T> getWeather(String cityName);

    public WeatherServer() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
        mServer = retrofit.create(CurrentWeatherAPI.class);
    }
}
