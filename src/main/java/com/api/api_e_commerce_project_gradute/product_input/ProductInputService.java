package com.api.api_e_commerce_project_gradute.product_input;

import com.api.api_e_commerce_project_gradute.DTO.ProductInputAdd;
import com.api.api_e_commerce_project_gradute.product.Product;
import com.api.api_e_commerce_project_gradute.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInputService {

  @Autowired
  ProductInputRepository productInputRepository;

  @Autowired
  ProductRepository productRepository;

  public List<ProductInput> getAllProductInputs() {
    return productInputRepository.findAll();
  }

  public Optional<ProductInput> getProductInputById(Long idProductInput) {
    return productInputRepository.findById(idProductInput);
  }

  public ProductInput addProductInput(ProductInput productInput) {
    return productInputRepository.save(productInput);
  }

  public ProductInput addProductInput(ProductInputAdd productInputAdd) {
    ProductInput productInput = productInputAdd.getProductInput();
    Product product = productRepository.getProductById(productInputAdd.getId());
    productInput.setProductInput(product);
    return productInputRepository.save(productInput);
  }

}
