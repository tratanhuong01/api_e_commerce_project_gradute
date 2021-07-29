package com.api.api_e_commerce_project_gradute.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(String idProduct) {
    return productRepository.getById(idProduct);
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

}
