package com.api.api_e_commerce_project_gradute.product_output;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductOutputAdd;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOutputService {

  @Autowired
  ProductOutputRepository productOutputRepository;

  @Autowired
  ProductRepository productRepository;

  public List<ProductOutput> getAllProductOutputs() {
    return productOutputRepository.findAll();
  }

  public Optional<ProductOutput> getProductOutputById(Long idProductOutput) {
    return productOutputRepository.findById(idProductOutput);
  }

  public ProductOutput addProductOutput(ProductOutput productOutput,String id) {
    productOutput.setProductOutputs(productRepository.getProductById(id));
    return productOutputRepository.save(productOutput);
  }

}
