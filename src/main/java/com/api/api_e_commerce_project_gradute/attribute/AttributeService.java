package com.api.api_e_commerce_project_gradute.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
    attribute.setTimeCreated((new Timestamp(new Date().getTime())));
    attributeRepository.save(attribute);
    return attributeRepository.findAll();
  }

  public List<Attribute> updateAttribute(Attribute attribute) {
    attributeRepository.save(attribute);
    return attributeRepository.findAll();
  }

  public List<Attribute> getAttributeByIdGroupAttribute(String id) {
    return attributeRepository.getAttributeByIdGroupAttribute(id);
  }

  public List<Attribute> searchAttributeAll(String keyword) {
    return attributeRepository.searchAttributeAll(keyword);
  }

  public List<Attribute> searchAttributeLimit(String keyword, int offset, int limit) {
    return attributeRepository.searchAttributeLimit(keyword,offset,limit);
  }

  public void deleteAttribute(Attribute attribute) {
    attributeRepository.delete(attribute);
  }

}
