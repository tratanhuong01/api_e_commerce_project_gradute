package com.api.api_e_commerce_project_gradute.size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {

  @Autowired
  SizeRepository sizeRepository;

  public List<Size> getAllSizes() {
    return sizeRepository.findAll();
  }

  public Size getSizeById(String idSize) {
    return sizeRepository.getById(idSize);
  }

  public Size addSize(Size size) {
    return sizeRepository.save(size);
  }

}
