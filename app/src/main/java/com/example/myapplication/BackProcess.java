package com.example.myapplication;

import android.app.Application;
import android.content.Intent;


public class BackProcess extends Application {
    public static BackProcess instance;
    @Override
    public void onCreate() {
        startService(new Intent(this,AlarmService.class));
        instance = this;
        super.onCreate();
    }

}
