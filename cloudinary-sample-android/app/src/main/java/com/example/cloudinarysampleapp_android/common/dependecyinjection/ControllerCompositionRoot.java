package com.example.cloudinarysampleapp_android.common.dependecyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.cloudinarysampleapp_android.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot mCompositionRoot, Activity activity) {
        this.mCompositionRoot = mCompositionRoot;
        this.mActivity = activity;
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }
}
