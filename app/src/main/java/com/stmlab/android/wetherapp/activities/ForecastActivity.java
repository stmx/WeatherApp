package com.stmlab.android.wetherapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.stmlab.android.wetherapp.R;
import com.stmlab.android.wetherapp.adapters.ForecastAdapter;
import com.stmlab.android.wetherapp.models.ForecastList;
import com.stmlab.android.wetherapp.presenters.ForecastPresenter;
import com.stmlab.android.wetherapp.views.ForecastView;

import java.util.ArrayList;

public class ForecastActivity extends MvpAppCompatActivity implements ForecastView {
    TextView mTextViewName;
    TextView mTextViewTemperature;
    RecyclerView mRecyclerView;
    ForecastAdapter mAdapter;

    @InjectPresenter
    ForecastPresenter mPresenter;

    public static Intent newInstance(Activity activity, int cityId) {
        Intent intent = new Intent(activity, ForecastActivity.class);
        intent.putExtra("extra_tag", cityId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        mTextViewName = findViewById(R.id.textViewCityName);
        mTextViewTemperature = findViewById(R.id.textViewTemperature);
        mRecyclerView = findViewById(R.id.recyclerViewForecast);
        mAdapter = new ForecastAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ForecastActivity.this));
        mRecyclerView.setAdapter(mAdapter);
        int cityId = getIntent().getIntExtra("extra_tag", 0);
        mPresenter.setupCityId(cityId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.unSubscribe();
    }

    @Override
    public void showName(String name) {
        mTextViewName.setText(name);
    }

    @Override
    public void showTemperature(double temperature) {
        mTextViewTemperature.setText("Сейчас: " + (temperature > 0 ? "+" : "") + String.valueOf(temperature));
    }

    @Override
    public void setupForecast(ArrayList<ForecastList> forecastLists) {
        mAdapter.setupForecastList(forecastLists);
    }

    @Override
    public void showError() {
        Toast.makeText(ForecastActivity.this, getString(R.string.errorDownloading), Toast.LENGTH_SHORT).show();
    }


}