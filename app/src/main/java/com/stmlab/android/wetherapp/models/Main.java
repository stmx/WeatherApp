package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @ColumnInfo(name = "main_temp")
    @SerializedName("temp")
    @Expose
    private double mTemperature;

    @ColumnInfo(name = "main_feels_like")
    @SerializedName("feels_like")
    @Expose
    private double mFeelsLike;

    @ColumnInfo(name = "main_temp_min")
    @SerializedName("temp_min")
    @Expose
    private double mTempMin;

    @ColumnInfo(name = "main_temp_max")
    @SerializedName("temp_max")
    @Expose
    private double mTempMax;

    @ColumnInfo(name = "main_pressure")
    @SerializedName("pressure")
    @Expose
    private int mPressure;

    @ColumnInfo(name = "main_humidity")
    @SerializedName("humidity")
    @Expose
    private int mHumidity;

    public double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(double temperature) {
        this.mTemperature = temperature;
    }

    public double getFeelsLike() {
        return mFeelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.mFeelsLike = feelsLike;
    }

    public double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(double tempMin) {
        this.mTempMin = tempMin;
    }

    public double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(double tempMax) {
        this.mTempMax = tempMax;
    }

    public int getPressure() {
        return mPressure;
    }

    public void setPressure(int pressure) {
        this.mPressure = pressure;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int humidity) {
        this.mHumidity = humidity;
    }
}
