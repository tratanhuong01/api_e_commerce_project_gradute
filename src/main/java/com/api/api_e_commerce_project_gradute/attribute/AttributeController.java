package com.api.api_e_commerce_project_gradute.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AttributeController {

  @Autowired
  AttributeService attributeService;

  @GetMapping("attributesAll")
  public List<Attribute> getAllAttributes() {
    return attributeService.getAllAttributes();
  }

  @GetMapping("attributes")
  public List<Attribute> getAllAttributeLimit() {
    return attributeService.getAllAttributesLimit(0,10);
  }

  @GetMapping("attributes/{offset}/{limit}")
  public List<Attribute> getAllAttributesLimit(@PathVariable int offset,@PathVariable int limit) {
    return attributeService.getAllAttributesLimit(offset, limit);
  }

  @PostMapping("attributes")
  public List<Attribute> addAttribute(@RequestBody Attribute attribute) {
    return attributeService.addAttribute(attribute);
  }

  @GetMapping("attributes/{id}")
  public List<Attribute> getAttributeByIdGroupAttribute(@PathVariable String id) {
    return attributeService.getAttributeByIdGroupAttribute(id);
  }

  @PutMapping("attributes")
  public List<Attribute> updateAttribute(@RequestBody Attribute attribute) {
    return attributeService.addAttribute(attribute);
  }

}
