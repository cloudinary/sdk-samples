import { Component } from '@angular/core';
import {Cloudinary} from '@cloudinary/url-gen'
import {Resize} from '@cloudinary/url-gen/actions'
import {accessibility, responsive} from "@cloudinary/ng";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cloudinary-sample-angular';
  cldInstance = new Cloudinary({cloud: {cloudName: '__CLOUD_NAME__'}});
  accessibilityPlugin = [accessibility()];

  // Fetch images from the web without uploading them
  fetchedImage = this.cldInstance
    .image('https://picsum.photos/200/300')
    .setDeliveryType('fetch');

  // Transform
  myImage = this.cldInstance
    .image('sample')
    .resize(Resize.fill().width(100).height(100))
}
