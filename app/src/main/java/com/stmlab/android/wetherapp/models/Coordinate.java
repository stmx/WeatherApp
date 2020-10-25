package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinate {
    @ColumnInfo(name = "coordinate_lon")
    @SerializedName("lon")
    @Expose
    private double mLongitude;

    @ColumnInfo(name = "coordinate_lat")
    @SerializedName("lat")
    @Expose
    private double mLatitude;

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        this.mLongitude = longitude;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        this.mLatitude = latitude;
    }
}
