package com.api.api_e_commerce_project_gradute.detail_function_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DetailFunctionProductController {

  @Autowired
  DetailFunctionProductService detailFunctionProductService;

  @GetMapping("detailFunctionProducts")
  public List<DetailFunctionProduct> getAllDetailFunctionProducts() {
    return detailFunctionProductService.getAllDetailFunctionProducts();
  }

  @PostMapping("detailFunctionProducts")
  public DetailFunctionProduct addDetailFunctionProduct(@RequestBody DetailFunctionProduct detailFunctionProduct) {
    return detailFunctionProductService.addDetailFunctionProduct(detailFunctionProduct);
  }

  @PutMapping("detailFunctionProducts")
  public DetailFunctionProduct updateDetailFunctionProduct(@RequestBody DetailFunctionProduct detailFunctionProduct)  {
    return detailFunctionProductService.addDetailFunctionProduct(detailFunctionProduct);
  }


}
