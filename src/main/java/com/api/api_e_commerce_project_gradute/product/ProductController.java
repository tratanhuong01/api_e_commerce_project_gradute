package com.api.api_e_commerce_project_gradute.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @CrossOrigin
  @GetMapping("products")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @CrossOrigin
  @GetMapping("products/{idProduct}")
  public Product getProductById(@PathVariable String idProduct) {
    return productService.getProductById(idProduct);
  }

  @CrossOrigin
  @PostMapping("products")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @CrossOrigin
  @PutMapping("products")
  public Product updateProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

}
