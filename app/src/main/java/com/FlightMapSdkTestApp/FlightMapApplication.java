package com.FlightMapSdkTestApp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.mapbox.mapboxsdk.Mapbox;


public class FlightMapApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setaccesstoken();
    }

    public void setaccesstoken() {
        SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("MySharedPref", Context.MODE_APPEND);
        String accesstoken = sharedpref.getString("accesstoken", "");

        if (accesstoken !=null && !accesstoken.equalsIgnoreCase("")) {
            Mapbox.getInstance(getApplicationContext(), accesstoken);
        }
    }

}
