package com.api.api_e_commerce_project_gradute.attribute_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttributeProductController {

  @Autowired
  AttributeProductService attributeProductService;

  @CrossOrigin
  @GetMapping("attributeProductsAll")
  public List<AttributeProduct> getAllAttributeProduct() {
    return attributeProductService.getAllAttributeProduct();
  }

  @CrossOrigin
  @GetMapping("attributeProducts")
  public List<AttributeProduct> getAllAttributeProductLimit() {
    return attributeProductService.getAllAttributeProductLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("attributeProducts/{offset}/{limit}")
  public List<AttributeProduct> getAllAttributeProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return attributeProductService.getAllAttributeProductLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("attributeProducts")
  public List<AttributeProduct> addAttributeProduct(@RequestBody AttributeProduct attributeProduct) {
    return attributeProductService.addAttributeProduct(attributeProduct);
  }

  @CrossOrigin
  @PutMapping("attributeProducts")
  public List<AttributeProduct> updateAttributeProduct(@RequestBody AttributeProduct attributeProduct) {
    return attributeProductService.addAttributeProduct(attributeProduct);
  }

}
