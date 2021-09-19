package com.api.api_e_commerce_project_gradute.attribute_product;

import com.api.api_e_commerce_project_gradute.DTO.AttributeByGroupAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AttributeProductController {

  @Autowired
  AttributeProductService attributeProductService;

  @GetMapping("attributeProductsAll")
  public List<AttributeProduct> getAllAttributeProduct() {
    return attributeProductService.getAllAttributeProduct();
  }

  @GetMapping("attributeProducts")
  public List<AttributeProduct> getAllAttributeProductLimit() {
    return attributeProductService.getAllAttributeProductLimit(0,10);
  }

  @GetMapping("attributeProducts/{idLineProduct}")
  public List<AttributeByGroupAttribute> getAttributeProductByIdLineProduct(@PathVariable String idLineProduct) {
    return attributeProductService.getAttributeProductByIdLineProduct(idLineProduct);
  }

  @GetMapping("attributeProducts/{offset}/{limit}")
  public List<AttributeProduct> getAllAttributeProductLimit(@PathVariable int offset,@PathVariable int limit) {
    return attributeProductService.getAllAttributeProductLimit(offset, limit);
  }

  @PostMapping("attributeProducts")
  public List<AttributeProduct> addAttributeProduct(@RequestBody AttributeProduct attributeProduct) {
    return attributeProductService.addAttributeProduct(attributeProduct);
  }

  @PutMapping("attributeProducts")
  public List<AttributeProduct> updateAttributeProduct(@RequestBody AttributeProduct attributeProduct) {
    return attributeProductService.addAttributeProduct(attributeProduct);
  }

}
