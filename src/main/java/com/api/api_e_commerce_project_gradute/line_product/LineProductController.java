package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LineProductController {

  @Autowired
  LineProductService lineProductService;

  @CrossOrigin
  @GetMapping("lineProducts")
  public List<LineProduct> getAllLineProducts() {
    return lineProductService.getAllLineProducts();
  }

  @CrossOrigin
  @GetMapping("lineProducts/{idLineProduct}")
  public Optional<LineProduct> getLineProductById(@PathVariable String idLineProduct) {
    return lineProductService.getLineProductById(idLineProduct);
  }

  @CrossOrigin
  @PostMapping("lineProducts")
  public LineProduct addLineProduct(@RequestBody LineProduct lineProduct) {
    return lineProductService.addLineProduct(lineProduct);
  }

  @CrossOrigin
  @PutMapping("lineProducts")
  public LineProduct updateLineProduct(@RequestBody LineProduct lineProduct) {
    return lineProductService.addLineProduct(lineProduct);
  }

}
