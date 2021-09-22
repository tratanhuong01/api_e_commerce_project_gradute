package com.api.api_e_commerce_project_gradute.function_product;

import com.api.api_e_commerce_project_gradute.DTO.function_product.FilterByGroupProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class FunctionProductController {

  @Autowired
  FunctionProductService functionProductService;

  // admin
  @GetMapping("functionProductsAll/search/")
  public List<FunctionProduct> searchFunctionProductAll(@RequestParam(required = false) String keyword) {
    return functionProductService.searchFunctionProductAll(keyword);
  }

  @GetMapping("functionProducts/search/")
  public List<FunctionProduct> searchFunctionProductLimit(@RequestParam(required = false) String keyword,
                                                        @RequestParam(required = false) int offset,
                                                        @RequestParam(required = false) int limit) {
    return functionProductService.searchFunctionProductLimit(keyword,offset,limit);
  }

  @DeleteMapping("functionProducts")
  public void deleteFunctionProduct(@RequestBody FunctionProduct functionProduct) {
    functionProductService.deleteFunctionProduct(functionProduct);
  }

  // user

  @GetMapping("functionProductsAll")
  public List<FunctionProduct> getAllFunctionProducts() {
    return functionProductService.getAllFunctionProducts();
  }

  @GetMapping("functionProducts")
  public List<FunctionProduct> getAllFunctionProductLimit() {
    return functionProductService.getAllFunctionProductLimit(0,10);
  }

  @GetMapping("functionProducts/{offset}/{limit}")
  public List<FunctionProduct> getAllFunctionProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return functionProductService.getAllFunctionProductLimit(offset, limit);
  }

  @PostMapping("functionProducts")
  public List<FunctionProduct> addFunctionProduct(@RequestBody FunctionProduct functionProduct) {
    return functionProductService.addFunctionProduct(functionProduct);
  }

  @PutMapping("functionProducts")
  public List<FunctionProduct> updateFunctionProduct(@RequestBody FunctionProduct functionProduct) {
    return functionProductService.updateFunctionProduct(functionProduct);
  }

  @GetMapping("getFilterByGroupProduct/{slug}")
  public List<FilterByGroupProduct> getFilterByGroupProduct(@PathVariable String slug) {
    return functionProductService.getFilterByGroupProduct(slug);
  }

  @GetMapping("functionProductsBySlug/{slug}")
  public List<FunctionProduct> getFunctionProductsBySlug(@PathVariable String slug) {
    return functionProductService.getFunctionProductsBySlug(slug);
  }

}
