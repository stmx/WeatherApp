package com.stmlab.android.wetherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("main")
    @Expose
    private String mMain;
    @SerializedName("description")
    @Expose
    private String mDescription;
    @SerializedName("icon")
    @Expose
    private String mIcon;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String main) {
        this.mMain = main;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }
}
