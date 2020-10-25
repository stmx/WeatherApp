package com.stmlab.android.wetherapp.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.stmlab.android.wetherapp.models.CurrentWeather;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface CurrentWeatherDao {

    @Query("SELECT * FROM currentWeather ORDER BY name ASC")
    Flowable<List<CurrentWeather>> getAllAnswer();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertCurrentWeather(CurrentWeather currentWeather);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertCurrentWeatherList(List<CurrentWeather> currentWeather);
}
