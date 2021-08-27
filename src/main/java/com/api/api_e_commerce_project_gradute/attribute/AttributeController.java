package com.api.api_e_commerce_project_gradute.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttributeController {

  @Autowired
  AttributeService attributeService;

  @CrossOrigin
  @GetMapping("attributesAll")
  public List<Attribute> getAllAttributes() {
    return attributeService.getAllAttributes();
  }

  @CrossOrigin
  @GetMapping("attributes")
  public List<Attribute> getAllAttributeLimit() {
    return attributeService.getAllAttributesLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("attributes/{offset}/{limit}")
  public List<Attribute> getAllAttributesLimit(@PathVariable int offset,@PathVariable int limit) {
    return attributeService.getAllAttributesLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("attributes")
  public List<Attribute> addAttribute(@RequestBody Attribute attribute) {
    return attributeService.addAttribute(attribute);
  }

  @CrossOrigin
  @GetMapping("attributes/{id}")
  public List<Attribute> getAttributeByIdGroupAttribute(@PathVariable String id) {
    return attributeService.getAttributeByIdGroupAttribute(id);
  }

  @CrossOrigin
  @PutMapping("attributes")
  public List<Attribute> updateAttribute(@RequestBody Attribute attribute) {
    return attributeService.addAttribute(attribute);
  }

}
