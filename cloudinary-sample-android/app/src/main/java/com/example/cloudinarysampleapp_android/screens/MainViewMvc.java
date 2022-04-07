package com.example.cloudinarysampleapp_android.screens;

import android.view.View;

public interface MainViewMvc {

    public interface Listener {
        public void OnButtonClicked(int buttonId);
    }

    void registerListener(Listener listener);

    void unregisterListerner(Listener listener);

    View getRootView();
}
