package com.api.api_e_commerce_project_gradute.image_other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageOtherController {

  @Autowired
  ImageOtherService imageOtherService;

  @CrossOrigin
  @GetMapping("imageOthers")
  public List<ImageOther> getAllImageOthers() {
    return imageOtherService.getAllImageOthers();
  }

  @CrossOrigin
  @GetMapping("imageOthers/{idLineProduct}")
  public List<ImageOther> getImageOtherByIdLineProduct(@PathVariable String idLineProduct) {
    return imageOtherService.getImageOtherByIdLineProduct(idLineProduct);
  }

  @CrossOrigin
  @PostMapping("imageOthers")
  public ImageOther addImageOther(@RequestBody ImageOther imageOther) {
    return imageOtherService.addImageOther(imageOther);
  }

  @CrossOrigin
  @PutMapping("imageOthers")
  public ImageOther updateImageOther(@RequestBody ImageOther imageOther) {
    return imageOtherService.addImageOther(imageOther);
  }

}
