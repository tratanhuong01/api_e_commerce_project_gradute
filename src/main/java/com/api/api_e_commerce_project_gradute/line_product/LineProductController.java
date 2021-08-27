package com.api.api_e_commerce_project_gradute.line_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Optional;

@RestController
public class LineProductController {

  @Autowired
  LineProductService lineProductService;

  @CrossOrigin
  @GetMapping("lineProductsAll")
  public List<LineProduct> getAllLineProducts() {
    return lineProductService.getAllLineProducts();
  }

  @CrossOrigin
  @GetMapping("lineProducts")
  public List<LineProduct> getAllLineProductLimit() {
    return lineProductService.getAllLineProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("lineProducts/{offset}/{limit}")
  public List<LineProduct> getAllLineProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return lineProductService.getAllLineProductLimit(offset, limit);
  }

  @CrossOrigin
  @GetMapping("lineProducts/{idLineProduct}")
  public Optional<LineProduct> getLineProductById(@PathVariable String idLineProduct) {
    return lineProductService.getLineProductById(idLineProduct);
  }

  @CrossOrigin
  @GetMapping("getLineProductsByGroup/{idGroup}")
  public List<LineProduct> getLineProductByIdGroupProduct(@PathVariable String idGroup) {
    return lineProductService.getLineProductByIdGroupProduct(idGroup);
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
