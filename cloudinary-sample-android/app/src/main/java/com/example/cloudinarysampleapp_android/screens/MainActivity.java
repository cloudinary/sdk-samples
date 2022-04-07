package com.example.cloudinarysampleapp_android.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.ErrorInfo;
import com.cloudinary.android.callback.UploadCallback;
import com.example.cloudinarysampleapp_android.Helpers.CloudinaryHelper;
import com.example.cloudinarysampleapp_android.R;

import java.util.Map;

interface OnButtonClickListener {
    void onButtonClick(int buttonId);
}

public class MainActivity extends AppCompatActivity implements MainViewMvcImpl.Listener {

    MainViewMvcImpl mainViewMvcImpl;

    private String currentImageId;

    private CloudinaryHelper cloudinaryHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewMvcImpl = new MainViewMvcImpl(LayoutInflater.from(this), null);
        mainViewMvcImpl.registerListener(this);
        setContentView(mainViewMvcImpl.getRootView());
        cloudinaryHelper = new CloudinaryHelper(this);
    }

    @Override
    public void OnButtonClicked(int buttonId) {
        switch (buttonId) {
            case R.id.btnUpload:
                uploadImage();
                break;
            case R.id.btnTransform:
                transformImage();
                break;
        }
    }

    private void uploadImage() {
        Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.cld_sample);
        cloudinaryHelper.uploadImage(imageUri, new UploadCallback() {
            @Override
            public void onStart(String requestId) {
                Log.d("Sample App", "Upload on Start");
            }

            @Override
            public void onProgress(String requestId, long bytes, long totalBytes) {
                Log.d("Sample App", "Upload on Progress");
            }

            @Override
            public void onSuccess(String requestId, Map resultData) {
                Log.d("Sample App", "Upload on Success");
                currentImageId = (String) resultData.get("public_id");
                MediaManager.get().download(MainActivity.this).load(currentImageId).into(mainViewMvcImpl.getImageView(ImageType.Upload));
            }

            @Override
            public void onError(String requestId, ErrorInfo error) {
                Log.d("Sample App", "Upload on Error");
            }

            @Override
            public void onReschedule(String requestId, ErrorInfo error) {
                Log.d("Sample App", "Upload on Reschedule");
            }
        });
    }

    private void transformImage() {
        if (currentImageId != null) {
            MediaManager.get().download(this).transformation(cloudinaryHelper.getTransformation()).load(currentImageId).into(mainViewMvcImpl.getImageView(ImageType.Transform));
        }
    }
}