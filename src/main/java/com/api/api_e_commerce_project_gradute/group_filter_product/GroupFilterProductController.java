package com.api.api_e_commerce_project_gradute.group_filter_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class GroupFilterProductController {

  @Autowired
  GroupFilterProductService groupFilterProductService;

  @GetMapping("groupFilterProductsAll")
  public List<GroupFilterProduct> getAllGroupFilterProducts() {
    return groupFilterProductService.getAllGroupFilterProducts();
  }

  @GetMapping("groupFilterProducts")
  public List<GroupFilterProduct> getAllGroupFilterProduct() {
    return groupFilterProductService.getAllGroupFilterProductLimit(0,10);
  }

  @GetMapping("groupFilterProducts/{offset}/{limit}")
  public List<GroupFilterProduct> getALlGroupFilterProducts(@PathVariable int offset, @PathVariable int limit) {
    return groupFilterProductService.getAllGroupFilterProductLimit(offset, limit);
  }

  @PostMapping("groupFilterProducts")
  public List<GroupFilterProduct> addGroupFilterProduct(@RequestBody GroupFilterProduct groupFilterProduct) {
    return groupFilterProductService.addGroupFilterProduct(groupFilterProduct);
  }

}
