package com.stmlab.android.wetherapp.views;

import com.arellomobile.mvp.MvpView;
import com.stmlab.android.wetherapp.models.ForecastList;

import java.util.ArrayList;

public interface ForecastView extends MvpView {
    void showName(String name);

    void showTemperature(double temperature);

    void setupForecast(ArrayList<ForecastList> forecastLists);

    void showError();
}
