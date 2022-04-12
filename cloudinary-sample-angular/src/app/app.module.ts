import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CloudinaryModule } from "@cloudinary/ng";

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CloudinaryModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
