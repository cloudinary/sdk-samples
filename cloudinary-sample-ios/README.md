# iOS app

This is a sample app for [iOS](https://developer.apple.com/tutorials/app-dev-training) app.

## Get started

### Integration 

The Cloudinary SDK was integrated using Swift Package Manager:

File > Add Packages... >
Add https://github.com/cloudinary/cloudinary_ios.git
Select "Up to Next Major" with "3.0.0"

## Usage

### Setup

Make sure to populate `API_KEY`, `API_SECRET` and `CLOUD_NAME` in `CloudinaryHelper` class.

### Upload

The following example for upload to cloud can be found in `CloudinaryHelper` class:

``` 
cloudinary.createUploader().signedUpload(data: data, params: params, completionHandler: { response, error in
    ...
    }
```

### Transform

The following example on how to perform transformation can be found in `CloudinaryHelper` class:

```
let transformation = CLDTransformation().setAngle("hflip").setEffect("cartoonify")
        guard let url = cloudinary.createUrl().setTransformation(transformation).generate(id) else {
            return nil
   }
```

