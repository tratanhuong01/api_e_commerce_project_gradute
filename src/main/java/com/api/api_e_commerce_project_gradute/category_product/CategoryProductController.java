package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryProductController {

  @Autowired
  CategoryProductService categoryProductService;

  @CrossOrigin
  @GetMapping("categoryProducts")
  public List<CategoryProduct> getAllCategoryProducts() {
    return categoryProductService.getAllCategoryProducts();
  }

  @CrossOrigin
  @GetMapping("categoryProducts/{idCategoryProduct}")
  public CategoryProduct getCategoryProductById(@PathVariable String idCategoryProduct) {
    return categoryProductService.getCategoryProductById(idCategoryProduct);
  }

  @CrossOrigin
  @PostMapping("categoryProducts")
  public CategoryProduct addCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
    return categoryProductService.addCategoryProduct(categoryProduct);
  }

  @CrossOrigin
  @PutMapping("categoryProducts")
  public CategoryProduct updateCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
    return categoryProductService.addCategoryProduct(categoryProduct);
  }

}
