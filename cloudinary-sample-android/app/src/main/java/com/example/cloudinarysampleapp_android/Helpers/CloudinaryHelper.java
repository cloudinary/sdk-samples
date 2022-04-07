package com.example.cloudinarysampleapp_android.Helpers;

import android.content.Context;
import android.net.Uri;

import com.cloudinary.Transformation;
import com.cloudinary.android.MediaManager;
import com.cloudinary.android.callback.UploadCallback;
import com.cloudinary.android.download.glide.GlideDownloadRequestBuilderFactory;

public class CloudinaryHelper {

    public CloudinaryHelper(Context context) {
        MediaManager.init(context);
        MediaManager.get().setDownloadRequestBuilderFactory(new GlideDownloadRequestBuilderFactory());
    }

    public void uploadImage(Uri uri, UploadCallback callback) {
        MediaManager.get().upload(uri).callback(callback).dispatch();
    }

    public Transformation getTransformation() {
        return new Transformation().angle("hflip").effect("cartoonify");
    }

}
