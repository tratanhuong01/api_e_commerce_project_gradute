package com.api.api_e_commerce_project_gradute.size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

  @Autowired
  SizeRepository sizeRepository;

  public List<Size> getAllSizes() {
    return sizeRepository.findAll();
  }

  public Optional<Size> getSizeById(String idSize) {
    return sizeRepository.findById(idSize);
  }

  public Size addSize(Size size) {
    return sizeRepository.save(size);
  }

}
