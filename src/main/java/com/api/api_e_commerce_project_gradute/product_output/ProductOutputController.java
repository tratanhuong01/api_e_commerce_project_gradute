package com.api.api_e_commerce_project_gradute.product_output;

import com.api.api_e_commerce_project_gradute.DTO.product.ProductOutputAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductOutputController {

  @Autowired
  ProductOutputService productOutputService;

  @CrossOrigin
  @GetMapping("productOutputs")
  public List<ProductOutput> getAllProductOutputs() {
    return productOutputService.getAllProductOutputs();
  }

  @CrossOrigin
  @GetMapping("productOutputs/{idProductOutput}")
  public Optional<ProductOutput> getProductOutputById(@PathVariable Long idProductOutput) {
    return productOutputService.getProductOutputById(idProductOutput);
  }

  @CrossOrigin
  @PostMapping("productOutputs")
  public ProductOutput addProductOutput(@RequestBody ProductOutputAdd productOutputAdd) {
    return productOutputService.addProductOutput(productOutputAdd.getProductOutput(),productOutputAdd.getId());
  }

  @CrossOrigin
  @PutMapping("productOutputs")
  public ProductOutput updateProductOutput(@RequestBody ProductOutput productOutput) {
    return productOutputService.addProductOutput(productOutput,"");
  }

}
