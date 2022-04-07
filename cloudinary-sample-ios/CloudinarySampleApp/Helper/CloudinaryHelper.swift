//
//  CloudinaryHelper.swift
//  CloudinarySampleApp
//
//  Created by Adi Mizrahi on 05/04/2022.
//

import Foundation
import Cloudinary
import UIKit
class CloudinaryHelper {
    
    private var cloudinary: CLDCloudinary!
    
    func initCloudinary() {
        guard let config = CLDConfiguration(cloudinaryUrl: "cloudinary://<API_KEY>:<API_SECRET>@<CLOUD_NAME>") else {
            return
        }
        cloudinary = CLDCloudinary(configuration: config)
    }
    
    func getCloudinary() -> CLDCloudinary {
        return cloudinary
    }
    
    func uploadImage(data: Data, completionHandler: @escaping ((_ id: String?) -> Void)) {
        guard let cloudinary = cloudinary else {
            fatalError("must enter a cloudinary url in initCloudinary()")
        }
        let params: CLDUploadRequestParams = CLDUploadRequestParams().setPublicId("cld_sample").setResourceType(.image) as! CLDUploadRequestParams
        cloudinary.createUploader().signedUpload(data: data, params: params, completionHandler: { response, error in
            guard let response = response else {
                completionHandler(nil)
                return
            }
            completionHandler(response.publicId)
        })
    }
    
    func transformImage(id: String) -> String? {
        guard let cloudinary = cloudinary else {
            fatalError("must enter a cloudinary url in initCloudinary()")
        }
        let transformation = CLDTransformation().setAngle("hflip").setEffect("cartoonify")
        guard let url = cloudinary.createUrl().setTransformation(transformation).generate(id) else {
            return nil
        }
        return url
    }
    
    func getUrlFromId(id: String) -> String? {
        guard let cloudinary = cloudinary else {
            fatalError("must enter a cloudinary url in initCloudinary()")
        }
        guard let url = cloudinary.createUrl().generate(id) else {
            return nil
        }
        return url
    }
}

