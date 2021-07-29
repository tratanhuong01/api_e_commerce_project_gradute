package com.api.api_e_commerce_project_gradute.product_input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductInputController {

  @Autowired
  ProductInputService productInputService;

  @CrossOrigin
  @GetMapping("productInputs")
  public List<ProductInput> getAllProductInputs() {
    return productInputService.getAllProductInputs();
  }

  @CrossOrigin
  @GetMapping("productInputs/{idProductInput}")
  public ProductInput getProductInputById(@PathVariable Long idProductInput) {
    return productInputService.getProductInputById(idProductInput);
  }

}
