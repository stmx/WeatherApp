package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "currentWeather")
public class CurrentWeather {

    @Embedded
    @SerializedName("coord")
    @Expose
    private Coordinate mCoordinate;

    @Ignore
    @SerializedName("weather")
    @Expose
    private List<Weather> mWeatherList = null;

    @ColumnInfo(name = "base")
    @SerializedName("base")
    @Expose
    private String mBase;

    @Embedded
    @SerializedName("main")
    @Expose
    private Main mMain;

    @ColumnInfo(name = "visibility")
    @SerializedName("visibility")
    @Expose
    private int mVisibility;

    @Embedded
    @SerializedName("wind")
    @Expose
    private Wind mWind;

    @Embedded
    @SerializedName("clouds")
    @Expose
    private Clouds mClouds;

    @ColumnInfo(name = "dt")
    @SerializedName("dt")
    @Expose
    private int mDt;

    @Embedded
    @SerializedName("sys")
    @Expose
    private Sys mSys;

    @ColumnInfo(name = "timezone")
    @SerializedName("timezone")
    @Expose
    private int mTimezone;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    private int mId;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String mName;

    @ColumnInfo(name = "cod")
    @SerializedName("cod")
    @Expose
    private int cod;

    public Coordinate getCoordinate() {
        return mCoordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.mCoordinate = coordinate;
    }

    public List<Weather> getWeatherList() {
        return mWeatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.mWeatherList = weatherList;
    }

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        this.mBase = base;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        this.mMain = main;
    }

    public int getVisibility() {
        return mVisibility;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        this.mWind = wind;
    }

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        this.mClouds = clouds;
    }

    public int getDt() {
        return mDt;
    }

    public void setDt(int dt) {
        this.mDt = dt;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        this.mSys = sys;
    }

    public int getTimezone() {
        return mTimezone;
    }

    public void setTimezone(int timezone) {
        this.mTimezone = timezone;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( !(o instanceof CurrentWeather) ) return false;
        CurrentWeather that = (CurrentWeather) o;
        return mId == that.mId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mCoordinate, mWeatherList, mBase, mMain, mVisibility, mWind, mClouds, mDt, mSys, mTimezone, mId, mName, cod);
    }
}
