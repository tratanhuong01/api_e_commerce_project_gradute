package com.api.api_e_commerce_project_gradute.product_input;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductInputAdd;
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
  public Optional<ProductInput> getProductInputById(@PathVariable Long idProductInput) {
    return productInputService.getProductInputById(idProductInput);
  }

  @CrossOrigin
  @PostMapping("productInputs")
  public ProductInput addProductInput(@RequestBody ProductInputAdd productInputAdd) {
    return productInputService.addProductInput(productInputAdd);
  }

  @CrossOrigin
  @PutMapping("productInputs")
  public ProductInput updateProductInput(@RequestBody ProductInput productInput) {
    return productInputService.addProductInput(productInput);
  }

}
