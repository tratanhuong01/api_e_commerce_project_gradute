package com.api.api_e_commerce_project_gradute.group_attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupAttributesService {

  @Autowired
  GroupAttributesRepository groupAttributesRepository;

  public List<GroupAttribute> getAllGroupAttribute() {
    return groupAttributesRepository.findAll();
  }

  public List<GroupAttribute> getAllGroupAttributeLimit(int offset,int limit) {
    return groupAttributesRepository.getAllGroupAttributeLimit(offset, limit);
  }

  public List<GroupAttribute> addGroupAttribute(GroupAttribute groupAttribute) {
    groupAttributesRepository.save(groupAttribute);
    return groupAttributesRepository.findAll();
  }

}
