package com.example.cloudinarysampleapp_android;

import android.app.Application;

import com.example.cloudinarysampleapp_android.common.dependecyinjection.CompositionRoot;

public class SampleApplication extends Application {

    private CompositionRoot mCompostionRoot;

    @Override
    public void onCreate() {
        super.onCreate();

        mCompostionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompostionRoot() {
        return mCompostionRoot;
    }
}
