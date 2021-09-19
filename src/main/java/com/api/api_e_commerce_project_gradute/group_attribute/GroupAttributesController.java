package com.api.api_e_commerce_project_gradute.group_attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.acl.Group;
import java.util.List;

@CrossOrigin("*")
@RestController
public class GroupAttributesController {

  @Autowired
  GroupAttributesService groupAttributesService;

  @GetMapping("groupAttributesAll")
  public List<GroupAttribute> getAllGroupAttributes() {
    return groupAttributesService.getAllGroupAttribute();
  }

  @GetMapping("groupAttributes")
  public List<GroupAttribute> getAllGroupAttributesLimit() {
    return groupAttributesService.getAllGroupAttributeLimit(0,10);
  }

  @GetMapping("groupAttributes/{offset}/{limit}")
  public List<GroupAttribute> getAllGroupAttributeLimit(@PathVariable int offset,@PathVariable int limit) {
    return groupAttributesService.getAllGroupAttributeLimit(offset, limit);
  }

  @PostMapping("groupAttributes")
  public List<GroupAttribute> addGroupAttribute(@RequestBody GroupAttribute groupAttribute) {
    return groupAttributesService.addGroupAttribute(groupAttribute);
  }

  @PutMapping("groupAttributes")
  public List<GroupAttribute> updateGroupAttribute(@RequestBody GroupAttribute groupAttribute) {
    return groupAttributesService.addGroupAttribute(groupAttribute);
  }

}
