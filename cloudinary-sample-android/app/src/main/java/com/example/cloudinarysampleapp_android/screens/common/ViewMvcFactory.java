package com.example.cloudinarysampleapp_android.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.cloudinarysampleapp_android.screens.MainViewMvc;
import com.example.cloudinarysampleapp_android.screens.MainViewMvcImpl;

public class ViewMvcFactory {

    public LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.mLayoutInflater = layoutInflater;
    }

    public MainViewMvcImpl getMainViewMvc(@Nullable ViewGroup parent) {
        return new MainViewMvcImpl(mLayoutInflater, parent);
    }
}
