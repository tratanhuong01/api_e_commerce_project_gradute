package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupProductController {

  @Autowired
  GroupProductService groupProductService;

  @CrossOrigin
  @GetMapping("groupProducts")
  public List<GroupProduct> getAllGroupProducts() {
    return groupProductService.getAllGroupProducts();
  }

  @CrossOrigin
  @GetMapping("groupProducts/{idGroupProduct}")
  public GroupProduct getGroupProductById(@PathVariable String idGroupProduct) {
    return groupProductService.getGroupProductById((idGroupProduct));
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
