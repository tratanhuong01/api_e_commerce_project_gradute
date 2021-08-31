package com.api.api_e_commerce_project_gradute.group_filter_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupFilterProductController {

  @Autowired
  GroupFilterProductService groupFilterProductService;

  @CrossOrigin
  @GetMapping("groupFilterProductsAll")
  public List<GroupFilterProduct> getAllGroupFilterProducts() {
    return groupFilterProductService.getAllGroupFilterProducts();
  }

  @CrossOrigin
  @GetMapping("groupFilterProducts")
  public List<GroupFilterProduct> getAllGroupFilterProduct() {
    return groupFilterProductService.getAllGroupFilterProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("groupFilterProducts/{offset}/{limit}")
  public List<GroupFilterProduct> getALlGroupFilterProducts(@PathVariable int offset, @PathVariable int limit) {
    return groupFilterProductService.getAllGroupFilterProductLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("groupFilterProducts")
  public List<GroupFilterProduct> addGroupFilterProduct(@RequestBody GroupFilterProduct groupFilterProduct) {
    return groupFilterProductService.addGroupFilterProduct(groupFilterProduct);
  }

}
