package com.api.api_e_commerce_project_gradute.image_other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageOtherService {

  @Autowired
  ImageOtherRepository imageOtherRepository;

  public List<ImageOther> getAllImageOthers() {
    return imageOtherRepository.findAll();
  }

  public List<ImageOther> getImageOtherByIdLineProduct(String idLineProduct) {
    return imageOtherRepository.getImageOtherByIdLineProduct(idLineProduct);
  }

  public ImageOther addImageOther(ImageOther imageOther) {
    return imageOtherRepository.save(imageOther);
  }

}
