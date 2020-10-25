package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {
    @ColumnInfo(name = "sys_type")
    @SerializedName("type")
    @Expose
    private int mType;

    @ColumnInfo(name = "sys_id")
    @SerializedName("id")
    @Expose
    private int mId;

    @ColumnInfo(name = "sys_message")
    @SerializedName("message")
    @Expose
    private double mMessage;

    @ColumnInfo(name = "sys_country")
    @SerializedName("country")
    @Expose
    private String mCountry;

    @ColumnInfo(name = "sys_sunrise")
    @SerializedName("sunrise")
    @Expose
    private int mSunrise;

    @ColumnInfo(name = "sys_sunset")
    @SerializedName("sunset")
    @Expose
    private int mSunset;

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public double getMessage() {
        return mMessage;
    }

    public void setMessage(double message) {
        this.mMessage = message;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        this.mCountry = country;
    }

    public int getSunrise() {
        return mSunrise;
    }

    public void setSunrise(int sunrise) {
        this.mSunrise = sunrise;
    }

    public int getSunset() {
        return mSunset;
    }

    public void setSunset(int sunset) {
        this.mSunset = sunset;
    }
}
