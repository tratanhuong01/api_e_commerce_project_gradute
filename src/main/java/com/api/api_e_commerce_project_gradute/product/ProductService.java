package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.ProductFull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(String idProduct) {
    return productRepository.findById(idProduct);
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  public Product getIdBestNew() {
    return productRepository.getIdBestNew();
  }

  public List<ProductFull> getAllProductFull() {
    List<ProductFull> productFullList = new ArrayList<>();

    return productFullList;
  }

}
