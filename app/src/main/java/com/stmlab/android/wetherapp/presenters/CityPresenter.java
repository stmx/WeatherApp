package com.stmlab.android.wetherapp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.stmlab.android.wetherapp.MyApp;
import com.stmlab.android.wetherapp.helpers.CurrentWeatherHelper;
import com.stmlab.android.wetherapp.models.CurrentWeather;
import com.stmlab.android.wetherapp.room.AppDatabaseRoom;
import com.stmlab.android.wetherapp.servers.CurrentWeatherServer;
import com.stmlab.android.wetherapp.views.CityView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

@InjectViewState
public class CityPresenter extends MvpPresenter<CityView> {
    CurrentWeatherServer mServer;
    Boolean firstAttached = true;
    AppDatabaseRoom mDatabaseRoom;
    Subject<String> subject = BehaviorSubject.create();
    public Disposable sub1;
    public Disposable sub2;

    public CityPresenter() {
        mServer = new CurrentWeatherServer();
        mDatabaseRoom = MyApp.getDatabase();
        sub2 = subject.flatMap(name -> mServer.getWeather(name))
                .doOnNext(currentWeather -> mDatabaseRoom.getCurrentWeatherDao().insertCurrentWeather(currentWeather))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(currentWeather -> {
                    CurrentWeatherHelper.INSTANCE.addCurrentWeatherList(currentWeather);
                    getViewState().setupAdapter(CurrentWeatherHelper.INSTANCE.getCurrentWeatherList());
                    Log.d("RxJava", "current city " + currentWeather.getName() + " dataInserted");
                }, (e) -> {
                    Log.d("RxJava", e.toString());
                    getViewState().showError();
                });
    }

    @Override
    protected void onFirstViewAttach() {
        sub1 = mDatabaseRoom.getCurrentWeatherDao().getAllAnswer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((weatherList) -> {
                    CurrentWeatherHelper.INSTANCE.setCurrentWeatherList((ArrayList<CurrentWeather>) weatherList);
                    getViewState().setupAdapter((ArrayList<CurrentWeather>) weatherList);
                    if ( firstAttached && !isInRestoreState(getViewState()) ) {
                        getViewState().updateAllCity();
                        getViewState().setDefaultCity();
                        firstAttached = false;
                    }
                    Log.d("RxJava", "current city from database " + weatherList.size());
                });
    }

    public void getWeatherByCity(String cityName) {
        subject.onNext(cityName);
    }

    public void unSubscribe() {
        if ( sub1 != null ) {
            sub1.dispose();
        }
        if ( sub2 != null ) {
            sub2.dispose();
        }
    }
}
