package com.stmlab.android.wetherapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {
    @ColumnInfo(name = "clouds_all")
    @SerializedName("all")
    @Expose
    private int mAll;

    public int getAll() {
        return mAll;
    }

    public void setAll(Integer all) {
        this.mAll = all;
    }
}
