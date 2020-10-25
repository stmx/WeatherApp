package com.stmlab.android.wetherapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stmlab.android.wetherapp.MyApp;
import com.stmlab.android.wetherapp.R;
import com.stmlab.android.wetherapp.adapters.CityAdapter;
import com.stmlab.android.wetherapp.helpers.CurrentWeatherHelper;
import com.stmlab.android.wetherapp.models.CurrentWeather;
import com.stmlab.android.wetherapp.presenters.CityPresenter;
import com.stmlab.android.wetherapp.views.CityView;

import java.util.ArrayList;

import static com.stmlab.android.wetherapp.MyApp.FIRST_START;


public class MainActivity extends MvpAppCompatActivity implements CityView {


    Button mButtonAddCity;
    Button mButtonUpdateAll;
    EditText mEditText;
    RecyclerView mRecyclerView;
    CityAdapter mCityAdapter;

    @InjectPresenter
    CityPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonAddCity = findViewById(R.id.buttonSearch);
        mButtonUpdateAll = findViewById(R.id.buttonUpdateAll);
        mEditText = findViewById(R.id.editTextTextPersonName);
        mCityAdapter = new CityAdapter();


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mCityAdapter);

        mButtonUpdateAll.setOnClickListener((v) -> {
            for (String cityName : CurrentWeatherHelper.INSTANCE.getCitesName()) {
                mPresenter.getWeatherByCity(cityName);
            }
        });

        mButtonAddCity.setOnClickListener((v) -> {
            mPresenter.getWeatherByCity(mEditText.getText().toString());
        });
        mCityAdapter.setOnItemClickListener(model -> {
            startActivity(ForecastActivity.newInstance(MainActivity.this, model.getId()));
        });

    }

    @Override
    protected void onStop() {
        mPresenter.unSubscribe();
        super.onStop();
    }

    @Override
    public void setupAdapter(ArrayList<CurrentWeather> currentWeathers) {
        mCityAdapter.setupCityList((ArrayList<CurrentWeather>) currentWeathers);

    }

    @Override
    public void showError() {
        Toast.makeText(MainActivity.this, getString(R.string.errorDownloading), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateAllCity() {
        for (String cityName : CurrentWeatherHelper.INSTANCE.getCitesName()) {
            mPresenter.getWeatherByCity(cityName);
        }
    }

    @Override
    public void setDefaultCity() {
        SharedPreferences sharedPreferences = getSharedPreferences(MyApp.STORAGE_NAME, MODE_PRIVATE);
        if ( sharedPreferences.getBoolean(FIRST_START, true) ) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(FIRST_START, false).apply();
            mPresenter.getWeatherByCity("Saint Petersburg");
            mPresenter.getWeatherByCity("Moscow");
        }
    }
}