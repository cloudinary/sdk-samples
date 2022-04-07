//
//  ImageHelper.swift
//  CloudinarySampleApp
//
//  Created by Adi Mizrahi on 05/04/2022.
//

import Foundation
import UIKit
class ImageHelper {
    static let shared = ImageHelper()
    
    func getImageData() -> Data? {
        guard let image = UIImage(named: "cld_sample.jpeg") else {
            return nil
        }
        return image.pngData()
    }
}
