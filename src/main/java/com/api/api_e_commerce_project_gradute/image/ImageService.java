package com.api.api_e_commerce_project_gradute.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

  @Autowired
  ImageRepository imageRepository;

  public List<Image> getAllImages() {
    return imageRepository.findAll();
  }

  public Image getImageById(Long idImage) {
    return imageRepository.getById(idImage);
  }

  public Image addImage(Image image) {
    return imageRepository.save(image);
  }

}
