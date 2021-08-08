package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;

@Service
public class LineProductService {

  @Autowired
  LineProductRepository lineProductRepository;

  public List<LineProduct> getAllLineProducts() {
    return lineProductRepository.findAll();
  }

  public LineProduct getLineProductById(String idLineProduct) {
    return lineProductRepository.getById(idLineProduct);
  }

  public LineProduct addLineProduct(LineProduct lineProduct) {
    return lineProductRepository.save(lineProduct);
  }

}
