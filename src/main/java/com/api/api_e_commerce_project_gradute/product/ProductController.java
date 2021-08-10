package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
  public Optional<Product> getProductById(@PathVariable String idProduct) {
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

  @CrossOrigin
  @GetMapping("getIdBestNew")
  public Product getIdBestNew() {
    return productService.getIdBestNew();
  }

  @CrossOrigin
  @GetMapping("getAllProductFull")
  public List<ProductFull> getAllProductFull() {
    return productService.getAllProductFull();
  }

  @CrossOrigin
  @GetMapping("getProductByCategory/{category}")
  public List<ProductFull> getAllProductFull(@PathVariable String category) {
    return productService.getProductByCategory(category);
  }

  @CrossOrigin
  @GetMapping("getProductIndex")
  public ProductIndex getProductIndex() {
    return productService.getProductIndex();
  }

  @CrossOrigin
  @PostMapping("getProductBySlug")
  public ProductFull getProductBySlug(@RequestParam String slug) {
    return productService.getProductBySlug(slug);
  }

}
