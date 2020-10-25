package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {
    @ColumnInfo(name = "wind_speed")
    @SerializedName("speed")
    @Expose
    private double mSpeed;

    @ColumnInfo(name = "wind_deg")
    @SerializedName("deg")
    @Expose
    private int mDegrees;

    public double getSpeed() {
        return mSpeed;
    }

    public void setSpeed(double speed) {
        this.mSpeed = speed;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public void setDegrees(int degrees) {
        this.mDegrees = degrees;
    }
}
