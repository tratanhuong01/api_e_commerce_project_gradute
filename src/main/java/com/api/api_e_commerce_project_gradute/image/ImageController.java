package com.api.api_e_commerce_project_gradute.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {

  @Autowired
  ImageService imageService;

  @CrossOrigin
  @GetMapping("images")
  public List<Image> getAllImages() {
    return imageService.getAllImages();
  }

  @CrossOrigin
  @GetMapping("images/{idImage}")
  public Image getImageById(@PathVariable Long idImage) {
    return imageService.getImageById(idImage);
  }

  @CrossOrigin
  @PostMapping("images")
  public Image addImage(@RequestBody Image image) {
    return imageService.addImage(image);
  }

  @CrossOrigin
  @PutMapping("images")
  public Image updateImage(@RequestBody Image image) {
    return imageService.addImage(image);
  }

}
