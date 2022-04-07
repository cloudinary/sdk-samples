//
//  ViewController.swift
//  CloudinarySampleApp
//
//  Created by Adi Mizrahi on 05/04/2022.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var ivUpload: UIImageView!
    @IBOutlet weak var ivTransform: UIImageView!
    @IBOutlet weak var btnUpload: UIButton!
    @IBOutlet weak var btnTransform: UIButton!
    
    
    private var currentImageId: String?
    
    private var cloudinaryHelper: CloudinaryHelper!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setButtons()
        cloudinaryHelper = CloudinaryHelper()
        cloudinaryHelper.initCloudinary()
    }
    
    func setButtons() {
        btnUpload.addTarget(self, action: #selector(uploadImage), for: .touchUpInside)
        btnTransform.addTarget(self, action: #selector(transformImage), for: .touchUpInside)
    }
    
    @objc func uploadImage() {
        guard let data = ImageHelper.shared.getImageData() else {
            return
        }
        cloudinaryHelper.uploadImage(data: data) { id in
            guard let id = id else {
                return
            }
            self.currentImageId = id
            self.btnTransform.isEnabled = true
            guard let url = self.cloudinaryHelper.getUrlFromId(id: id) else {
                return
            }
            self.ivUpload.cldSetImage(url, cloudinary: self.cloudinaryHelper.getCloudinary())
        }
        
    }
    
    @objc func transformImage() {
        guard let currentImageId = currentImageId, let url = cloudinaryHelper.transformImage(id: currentImageId) else {
            return
        }
        
        ivTransform.cldSetImage(url, cloudinary: cloudinaryHelper.getCloudinary(), placeholder: nil)
    }


}

