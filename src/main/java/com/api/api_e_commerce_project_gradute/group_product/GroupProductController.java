package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class GroupProductController {

  @Autowired
  GroupProductService groupProductService;

  @GetMapping("groupProductsAll")
  public List<GroupProduct> getAllGroupProducts() {
    return groupProductService.getAllGroupProducts();
  }

  @GetMapping("groupProducts")
  public List<GroupProduct> getAllGroupProductLimit() {
    return groupProductService.getGroupProductLimit(0,10);
  }

  @GetMapping("groupProducts/{offset}/{limit}")
  public List<GroupProduct> getAllGroupProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return groupProductService.getGroupProductLimit(offset, limit);
  }

  @GetMapping("groupProducts/{idGroupProduct}")
  public Optional<GroupProduct> getGroupProductById(@PathVariable String idGroupProduct) {
    return groupProductService.getGroupProductById((idGroupProduct));
  }

  @GetMapping("groupProductsByCategory/{idCategory}")
  public List<GroupProduct> getGroupProductByIdCategory(@PathVariable String idCategory) {
    return groupProductService.getGroupProductByIdCategoryProduct((idCategory));
  }

  @GetMapping("groupProductsBySlugCategory/{slugCategory}")
  public List<GroupProduct> getGroupProductBySlugCategory(@PathVariable String slugCategory) {
    return groupProductService.getGroupProductBySlugCategoryProduct(slugCategory);
  }

  @PostMapping("groupProducts")
  public GroupProduct addGroupProduct(@RequestBody GroupProduct groupProduct) {
    return groupProductService.addGroupProduct(groupProduct);
  }

  @PutMapping("groupProducts")
  public GroupProduct updateGroupProduct(@RequestBody GroupProduct groupProduct) {
    return groupProductService.addGroupProduct(groupProduct);
  }

}
