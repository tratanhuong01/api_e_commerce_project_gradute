package com.api.api_e_commerce_project_gradute.value_attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValueAttributeController {

  @Autowired
  ValueAttributeService valueAttributeService;

  @CrossOrigin
  @GetMapping("valueAttributesAll")
  public List<ValueAttribute> getAllValueAttribute() {
    return valueAttributeService.getAllValueAttribute();
  }

  @CrossOrigin
  @GetMapping("valueAttributes")
  public List<ValueAttribute> getValueAttributeLimit() {
    return valueAttributeService.getAllValueAtributeLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("valueAttributes/{offset}/{limit}")
  public List<ValueAttribute> getValueAttributeLimit(@PathVariable int offset,@PathVariable int limit) {
    return valueAttributeService.getAllValueAtributeLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("valueAttributes")
  public List<ValueAttribute> addValueAttribute(@RequestBody ValueAttribute valueAttribute) {
    return valueAttributeService.addValueAttribute(valueAttribute);
  }

}
