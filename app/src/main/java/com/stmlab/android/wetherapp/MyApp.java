package com.stmlab.android.wetherapp;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.stmlab.android.wetherapp.room.AppDatabaseRoom;

public class MyApp extends Application {

    public static final String STORAGE_NAME = "StorageName";
    public static final String FIRST_START = "FirstStart";

    private static AppDatabaseRoom mDatabaseRoom;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabaseRoom = Room.databaseBuilder(getApplicationContext(), AppDatabaseRoom.class, "my_db").build();
    }

    public static AppDatabaseRoom getDatabase() {
        return mDatabaseRoom;
    }
}
