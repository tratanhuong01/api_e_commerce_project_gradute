package com.api.api_e_commerce_project_gradute.group_filter_product;

import com.api.api_e_commerce_project_gradute.function_product.FunctionProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class GroupFilterProductController {

  @Autowired
  GroupFilterProductService groupFilterProductService;

  // admin
  @GetMapping("groupFilterProductsAll/search/")
  public List<GroupFilterProduct> searchGroupFilterProductAll(@RequestParam(required = false) String keyword) {
    return groupFilterProductService.searchGroupFilterProductAll(keyword);
  }

  @GetMapping("groupFilterProducts/search/")
  public List<GroupFilterProduct> searchGroupFilterProductLimit(@RequestParam(required = false) String keyword,
                                                          @RequestParam(required = false) int offset,
                                                          @RequestParam(required = false) int limit) {
    return groupFilterProductService.searchGroupFilterProductLimit(keyword,offset,limit);
  }

  @DeleteMapping("groupFilterProducts")
  public void deleteGroupFilterProduct(@RequestBody GroupFilterProduct groupFilterProduct) {
    groupFilterProductService.deleteGroupFilterProduct(groupFilterProduct);
  }

  // user

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

  @PutMapping("groupFilterProducts")
  public List<GroupFilterProduct> updateGroupFilterProduct(@RequestBody GroupFilterProduct groupFilterProduct) {
    return groupFilterProductService.updateGroupFilterProduct(groupFilterProduct);
  }

  @PostMapping("groupFilterProducts")
  public List<GroupFilterProduct> addGroupFilterProduct(@RequestBody GroupFilterProduct groupFilterProduct) {
    return groupFilterProductService.addGroupFilterProduct(groupFilterProduct);
  }

}
