package com.api.api_e_commerce_project_gradute.product_output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOutputService {

  @Autowired
  ProductOutputRepository productOutputRepository;

  public List<ProductOutput> getAllProductOutputs() {
    return productOutputRepository.findAll();
  }

  public Optional<ProductOutput> getProductOutputById(Long idProductOutput) {
    return productOutputRepository.findById(idProductOutput);
  }

  public ProductOutput addProductOutput(ProductOutput productOutput) {
    return productOutputRepository.save(productOutput);
  }

}
