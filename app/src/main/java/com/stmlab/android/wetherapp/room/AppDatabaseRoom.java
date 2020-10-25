package com.stmlab.android.wetherapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.stmlab.android.wetherapp.models.CurrentWeather;

@Database(entities = {CurrentWeather.class}, version = 1, exportSchema = false)

public abstract class AppDatabaseRoom extends RoomDatabase {
    public abstract CurrentWeatherDao getCurrentWeatherDao();
}
