package com.api.api_e_commerce_project_gradute.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

  @Autowired
  AttributeRepository attributeRepository;

  public List<Attribute> getAllAttributes() {
    return attributeRepository.findAll();
  }

  public List<Attribute> getAllAttributesLimit(int offset,int limit) {
    return attributeRepository.getAllAttributeLimit(offset, limit);
  }

  public List<Attribute> addAttribute(Attribute attribute) {
    attributeRepository.save(attribute);
    return attributeRepository.findAll();
  }

  public List<Attribute> getAttributeByIdGroupAttribute(String id) {
    return attributeRepository.getAttributeByIdGroupAttribute(id);
  }

}
