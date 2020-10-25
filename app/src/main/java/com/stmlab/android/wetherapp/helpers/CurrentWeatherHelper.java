package com.stmlab.android.wetherapp.helpers;

import com.stmlab.android.wetherapp.models.CurrentWeather;

import java.util.ArrayList;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class CurrentWeatherHelper {
    private ArrayList<CurrentWeather> mCurrentWeatherList;
    public static final CurrentWeatherHelper INSTANCE = new CurrentWeatherHelper();
    private Subject<ArrayList<CurrentWeather>> mObservable = PublishSubject.create();

    private CurrentWeatherHelper() {
        mCurrentWeatherList = new ArrayList<>();
    }

    public Subject<ArrayList<CurrentWeather>> getObservable() {
        return mObservable;
    }

    public CurrentWeather getCityById(int cityId) {
        for (CurrentWeather currentWeather : mCurrentWeatherList) {
            if ( currentWeather.getId() == cityId ) {
                return currentWeather;
            }
        }
        return null;
    }

    public ArrayList<CurrentWeather> getCurrentWeatherList() {
        return mCurrentWeatherList;
    }

    public void setCurrentWeatherList(ArrayList<CurrentWeather> currentWeatherList) {
        mCurrentWeatherList = currentWeatherList;
    }

    public void addCurrentWeatherList(CurrentWeather currentWeather) {
        if ( !mCurrentWeatherList.contains(currentWeather) ) {
            mCurrentWeatherList.add(currentWeather);
        }
    }

    public ArrayList<String> getCitesName() {
        ArrayList<String> mCitesList = new ArrayList<>();
        for (CurrentWeather currentWeather : mCurrentWeatherList) {
            mCitesList.add(currentWeather.getName());
        }
        return mCitesList;
    }
}
