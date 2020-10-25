package com.stmlab.android.wetherapp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.stmlab.android.wetherapp.helpers.CurrentWeatherHelper;
import com.stmlab.android.wetherapp.models.CurrentWeather;
import com.stmlab.android.wetherapp.models.ForecastList;
import com.stmlab.android.wetherapp.servers.ForecastWeatherServer;
import com.stmlab.android.wetherapp.views.ForecastView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ForecastPresenter extends MvpPresenter<ForecastView> {
    ForecastWeatherServer mServer;
    Disposable sub;

    public ForecastPresenter() {
        mServer = new ForecastWeatherServer();
    }

    @Override
    protected void onFirstViewAttach() {

    }

    public void setupCityId(int cityId) {
        CurrentWeather currentWeather = CurrentWeatherHelper.INSTANCE.getCityById(cityId);
        getViewState().showName(currentWeather.getName());
        getViewState().showTemperature(currentWeather.getMain().getTemperature());
        sub = mServer.getWeather(currentWeather.getName())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(forecastWeather -> {
                    Log.d("RxJava", "setup  List " + forecastWeather.getList().size());
                    getViewState().setupForecast((ArrayList<ForecastList>) forecastWeather.getList());
                }, (e) -> {
                    getViewState().showError();
                });
    }

    public void unSubscribe() {
        if ( sub != null ) {
            sub.dispose();
        }
    }
}
