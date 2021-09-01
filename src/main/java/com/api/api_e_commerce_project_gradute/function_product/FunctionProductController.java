package com.api.api_e_commerce_project_gradute.function_product;

import com.api.api_e_commerce_project_gradute.DTO.function_product.FilterByGroupProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FunctionProductController {

  @Autowired
  FunctionProductService functionProductService;

  @CrossOrigin
  @GetMapping("functionProductsAll")
  public List<FunctionProduct> getAllFunctionProducts() {
    return functionProductService.getAllFunctionProducts();
  }

  @CrossOrigin
  @GetMapping("functionProducts")
  public List<FunctionProduct> getAllFunctionProductLimit() {
    return functionProductService.getAllFunctionProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("functionProducts/{offset}/{limit}")
  public List<FunctionProduct> getAllFunctionProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return functionProductService.getAllFunctionProductLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("functionProducts")
  public List<FunctionProduct> addFunctionProduct(@RequestBody FunctionProduct functionProduct) {
    return functionProductService.addFunctionProduct(functionProduct);
  }

  @PutMapping("functionProducts")
  public List<FunctionProduct> updateFunctionProduct(@RequestBody FunctionProduct functionProduct) {
    return functionProductService.addFunctionProduct(functionProduct);
  }

  @CrossOrigin
  @GetMapping("getFilterByGroupProduct/{slug}")
  public List<FilterByGroupProduct> getFilterByGroupProduct(@PathVariable String slug) {
    return functionProductService.getFilterByGroupProduct(slug);
  }

  @CrossOrigin
  @GetMapping("functionProductsBySlug/{slug}")
  public List<FunctionProduct> getFunctionProductsBySlug(@PathVariable String slug) {
    return functionProductService.getFunctionProductsBySlug(slug);
  }

}
