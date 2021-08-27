package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupProductController {

  @Autowired
  GroupProductService groupProductService;

  @CrossOrigin
  @GetMapping("groupProductsAll")
  public List<GroupProduct> getAllGroupProducts() {
    return groupProductService.getAllGroupProducts();
  }

  @CrossOrigin
  @GetMapping("groupProducts")
  public List<GroupProduct> getAllGroupProductLimit() {
    return groupProductService.getGroupProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("groupProducts/{offset}/{limit}")
  public List<GroupProduct> getAllGroupProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return groupProductService.getGroupProductLimit(offset, limit);
  }

  @CrossOrigin
  @GetMapping("groupProducts/{idGroupProduct}")
  public Optional<GroupProduct> getGroupProductById(@PathVariable String idGroupProduct) {
    return groupProductService.getGroupProductById((idGroupProduct));
  }

  @CrossOrigin
  @GetMapping("groupProductsByCategory/{idCategory}")
  public List<GroupProduct> getGroupProductByIdCategory(@PathVariable String idCategory) {
    return groupProductService.getGroupProductByIdCategoryProduct((idCategory));
  }

  @CrossOrigin
  @PostMapping("groupProducts")
  public GroupProduct addGroupProduct(@RequestBody GroupProduct groupProduct) {
    return groupProductService.addGroupProduct(groupProduct);
  }

  @CrossOrigin
  @PutMapping("groupProducts")
  public GroupProduct updateGroupProduct(@RequestBody GroupProduct groupProduct) {
    return groupProductService.addGroupProduct(groupProduct);
  }

}
