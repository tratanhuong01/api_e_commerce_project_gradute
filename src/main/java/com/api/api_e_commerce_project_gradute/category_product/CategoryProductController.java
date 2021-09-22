package com.api.api_e_commerce_project_gradute.category_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class CategoryProductController {

  @Autowired
  CategoryProductService categoryProductService;

  // admin
  @GetMapping("categoryProductsAll/search/")
  public List<CategoryProduct> searchCategoryProductAll(@RequestParam(required = false) String keyword) {
    return categoryProductService.searchCategoryProductAll(keyword);
  }

  @GetMapping("categoryProducts/search/")
  public List<CategoryProduct> searchCategoryProductLimit(@RequestParam(required = false) String keyword,
                                                        @RequestParam(required = false) int offset,
                                                        @RequestParam(required = false) int limit) {
    return categoryProductService.searchCategoryProductLimit(keyword,offset,limit);
  }

  // user

  @GetMapping("categoryProductsAll")
  public List<CategoryProduct> getAllCategoryProducts() {
    return categoryProductService.getAllCategoryProducts();
  }

  @GetMapping("categoryProducts")
  public List<CategoryProduct> getAllCategoryProductLimit() {
    return categoryProductService.getAllCategoryProductLimit(0,10);
  }

  @GetMapping("categoryProducts/{offset}/{limit}")
  public List<CategoryProduct> getAllCategoryProducts(@PathVariable int offset,@PathVariable int limit) {
    return categoryProductService.getAllCategoryProductLimit(offset, limit);
  }

  @GetMapping("categoryProducts/{idCategoryProduct}")
  public Optional<CategoryProduct> getCategoryProductById(@PathVariable String idCategoryProduct) {
    return categoryProductService.getCategoryProductById(idCategoryProduct);
  }

  @PostMapping("categoryProducts")
  public CategoryProduct addCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
    return categoryProductService.addCategoryProduct(categoryProduct);
  }

  @PutMapping("categoryProducts")
  public CategoryProduct updateCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
    return categoryProductService.updateCategoryProduct(categoryProduct);
  }

  @DeleteMapping("categoryProducts")
  public void deleteCategoryProduct(@RequestBody CategoryProduct categoryProduct) {
    categoryProductService.deleteCategoryProduct(categoryProduct);
  }

}
