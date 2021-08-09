package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Optional;

@Service
public class LineProductService {

  @Autowired
  LineProductRepository lineProductRepository;

  public List<LineProduct> getAllLineProducts() {
    return lineProductRepository.findAll();
  }

  public Optional<LineProduct> getLineProductById(String idLineProduct) {
    return lineProductRepository.findById(idLineProduct);
  }

  public LineProduct addLineProduct(LineProduct lineProduct) {
    LineProduct lineProductGet = lineProductRepository.getIdBestNew();
    if (lineProductGet == null)
      lineProduct.setId("LP1000000000");
    else {
      int id = Integer.parseInt(lineProductGet.getId().split("LP")[1]);
      id++;
      lineProduct.setId(String.valueOf("LP"+id));
    }
    return lineProductRepository.save(lineProduct);
  }

}
