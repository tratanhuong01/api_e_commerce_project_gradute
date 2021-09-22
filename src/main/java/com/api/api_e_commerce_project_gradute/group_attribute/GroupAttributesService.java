package com.api.api_e_commerce_project_gradute.group_attribute;

import com.api.api_e_commerce_project_gradute.category_product.CategoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
    groupAttribute.setTimeCreated(new Timestamp(new Date().getTime()));
    groupAttributesRepository.save(groupAttribute);
    return groupAttributesRepository.findAll();
  }

  public List<GroupAttribute> updateGroupAttribute(GroupAttribute groupAttribute) {
    groupAttributesRepository.save(groupAttribute);
    return groupAttributesRepository.findAll();
  }

  public List<GroupAttribute> searchGroupAttributeAll(String keyword) {
    return groupAttributesRepository.searchGroupAttributeAll(keyword);
  }

  public List<GroupAttribute> searchGroupAttributeLimit(String keyword,int offset,int limit) {
    return groupAttributesRepository.searchGroupAttributeLimit(keyword,offset,limit);
  }

  public void deleteGroupAttribute(GroupAttribute groupAttribute) {
    groupAttributesRepository.delete(groupAttribute);
  }

}
