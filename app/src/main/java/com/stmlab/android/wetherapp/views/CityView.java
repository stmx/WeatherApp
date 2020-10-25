package com.stmlab.android.wetherapp.views;

import com.arellomobile.mvp.MvpView;
import com.stmlab.android.wetherapp.models.CurrentWeather;

import java.util.ArrayList;

public interface CityView extends MvpView {
    void setupAdapter(ArrayList<CurrentWeather> currentWeathers);

    void showError();

    void updateAllCity();

    void setDefaultCity();
}
