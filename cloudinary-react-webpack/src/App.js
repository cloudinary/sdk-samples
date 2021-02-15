import React from "react";
import {CloudinaryImage} from "@cloudinary/base";
import {AdvancedImage, accessibility, lazyload, placeholder, responsive} from "@cloudinary/react";

const App = () => {
  const img = new CloudinaryImage('sample', {cloudName: 'demo'});
  return (
    <AdvancedImage
      cldImg={img}
      plugins={[lazyload(), responsive(), accessibility(), placeholder()]}
      style={{width: "100%"}}
      alt="Sample"
    />
  );
};

export default App;