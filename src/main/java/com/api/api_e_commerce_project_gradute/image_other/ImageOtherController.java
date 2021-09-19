package com.api.api_e_commerce_project_gradute.image_other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ImageOtherController {

  @Autowired
  ImageOtherService imageOtherService;

  @GetMapping("imageOthers")
  public List<ImageOther> getAllImageOthers() {
    return imageOtherService.getAllImageOthers();
  }

  @GetMapping("imageOthers/{idLineProduct}")
  public List<ImageOther> getImageOtherByIdLineProduct(@PathVariable String idLineProduct) {
    return imageOtherService.getImageOtherByIdLineProduct(idLineProduct);
  }

  @PostMapping("imageOthers")
  public ImageOther addImageOther(@RequestBody ImageOther imageOther) {
    return imageOtherService.addImageOther(imageOther);
  }

  @PutMapping("imageOthers")
  public ImageOther updateImageOther(@RequestBody ImageOther imageOther) {
    return imageOtherService.addImageOther(imageOther);
  }

}
