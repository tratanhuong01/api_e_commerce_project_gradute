package com.api.api_e_commerce_project_gradute.group_attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Group;
import java.util.List;

@RestController
public class GroupAttributesController {

  @Autowired
  GroupAttributesService groupAttributesService;

  @CrossOrigin
  @GetMapping("groupAttributesAll")
  public List<GroupAttribute> getAllGroupAttributes() {
    return groupAttributesService.getAllGroupAttribute();
  }

  @CrossOrigin
  @GetMapping("groupAttributes")
  public List<GroupAttribute> getAllGroupAttributesLimit() {
    return groupAttributesService.getAllGroupAttributeLimit(0,10);
  }

  @CrossOrigin
  @GetMapping("groupAttributes/{offset}/{limit}")
  public List<GroupAttribute> getAllGroupAttributeLimit(@PathVariable int offset,@PathVariable int limit) {
    return groupAttributesService.getAllGroupAttributeLimit(offset, limit);
  }

  @CrossOrigin
  @PostMapping("groupAttributes")
  public List<GroupAttribute> addGroupAttribute(@RequestBody GroupAttribute groupAttribute) {
    return groupAttributesService.addGroupAttribute(groupAttribute);
  }

  @CrossOrigin
  @PutMapping("groupAttributes")
  public List<GroupAttribute> updateGroupAttribute(@RequestBody GroupAttribute groupAttribute) {
    return groupAttributesService.addGroupAttribute(groupAttribute);
  }

}
