package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
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
  @GetMapping("products/{offset}/{limit}")
  public List<ProductFull> getProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return productService.getAllProductLimit(offset, limit);
  }

  @CrossOrigin
  @GetMapping("productsAll")
  public List<ProductFull> getAll() {
    return productService.getAllProducts();
  }

  @CrossOrigin
  @GetMapping("products")
  public List<ProductFull> getAllProducts() {
    return productService.getAllProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("products/{idProduct}")
  public Product getProductById(@PathVariable String idProduct) {
    return productService.getProductByIdMain(idProduct);
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
    return productService.getProductBySlug(slug,0);
  }

  @CrossOrigin
  @GetMapping("products/full/{id}")
  public ProductFull getProductByIdProduct(@PathVariable String id) {
    return productService.getProductBySlug(id,1);
  }

  @CrossOrigin
  @PostMapping("getSlug")
  public String getSlugByColorAndMemory(@RequestParam String idColor,@RequestParam String idMemory,
                                        @RequestParam String idLineProduct) {
    return productService.getSlugByColorAndMemory(idColor,idMemory,idLineProduct);
  }

  @CrossOrigin
  @PostMapping("getProductBySlugCategory")
  public List<ProductFull> getProductBySlugCategory(@RequestParam String slugCategoryProduct) {
    return productService.getProductBySlugCategory(slugCategoryProduct);
  }

  @CrossOrigin
  @PostMapping("getProductBySlugCategoryAndSlugGroup")
  public List<ProductFull> getProductBySlugCategoryAndSlugGroup(@RequestParam String slugCategoryProduct,
                                                            @RequestParam String slugGroupProduct) {
    return productService.getProductBySlugCategoryAndSlugGroup(slugCategoryProduct,slugGroupProduct);
  }
  @CrossOrigin
  @GetMapping("getCategoryByGroupProducts")
  public List<CategoryByGroupProduct> getCategoryByGroupProducts() {
    return productService.getCategoryByGroupProducts();
  }

}
