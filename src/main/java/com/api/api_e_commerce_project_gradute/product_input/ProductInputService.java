package com.api.api_e_commerce_project_gradute.product_input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInputService {

  @Autowired
  ProductInputRepository productInputRepository;

  public List<ProductInput> getAllProductInputs() {
    return productInputRepository.findAll();
  }

  public ProductInput getProductInputById(Long idProductInput) {
    return productInputRepository.getById(idProductInput);
  }

  public ProductInput addProductInput(ProductInput productInput) {
    return productInputRepository.save(productInput);
  }

}
