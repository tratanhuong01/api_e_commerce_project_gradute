package com.api.api_e_commerce_project_gradute.product;

import com.api.api_e_commerce_project_gradute.DTO.CategoryByGroupProduct;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductCriteria;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductFull;
import com.api.api_e_commerce_project_gradute.DTO.product.ProductIndex;
import com.api.api_e_commerce_project_gradute.color.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @CrossOrigin
  @GetMapping("productsFilter")
  public List<ProductFull> filterProduct(@RequestParam(name="feature", required = false) Set<Long> feature,
                                     @RequestParam(name="slugGroupProduct", required = false) String slugGroupProduct,
                                     @RequestParam(name="color", required = false) Set<Long> color,
                                     @RequestParam(name="ram", required = false) Set<Long> ram,
                                     @RequestParam(name="rom", required = false) Set<Long> rom,
                                     @RequestParam(name="brand", required = false) Set<String> brand,
                                     @RequestParam(name="priceFrom", required = false) Integer priceFrom,
                                     @RequestParam(name="priceTo", required = false) Integer priceTo,
                                     @RequestParam(name = "filter",required = false) String filter) {
    ProductCriteria productCriteria = ProductCriteria.builder().
        slugGroupProduct(slugGroupProduct).
        feature(feature).
        rom(rom).
        ram(ram).
        brand(brand).
        color(color).
        priceFrom(priceFrom).
        priceTo(priceTo).
        filter(filter).
        build();
    return productService.filterProduct(productCriteria);
  }

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
  @GetMapping("products/search/")
  public List<ProductFull> searchProduct(@RequestParam(required = false) String keyword,
                                         @RequestParam(required = false) String slug) {
    return productService.searchProduct(keyword,slug);
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
