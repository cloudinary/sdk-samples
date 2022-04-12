package com.example.cloudinarysampleapp_android.screens.common;

import androidx.appcompat.app.AppCompatActivity;
import com.example.cloudinarysampleapp_android.SampleApplication;
import com.example.cloudinarysampleapp_android.common.dependecyinjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((SampleApplication) getApplication()).getCompostionRoot(),
                    this);
        }
        return mControllerCompositionRoot;
    }
}
