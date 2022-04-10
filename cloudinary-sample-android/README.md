# Android app

This is a sample app for [Android](https://android.com) app.

## Get started

### Integration 

The following dependency added to build.gradle:

implementation 'com.cloudinary:cloudinary-android:2.1.0'

## Usage

### Setup

Make sure to populate `API_KEY`, `API_SECRET` and `CLOUD_NAME` fields in `AndroidManifest.xml`

### Upload

The following example for upload to cloud can be found in `CloudinaryHelper` class:

```MediaManager.get().upload(uri).callback(callback).dispatch();```

### Transform

The following example on how to perform transformation can be found in `CloudinaryHelper` class:

```Transformation().angle("hflip").effect("cartoonify");```

