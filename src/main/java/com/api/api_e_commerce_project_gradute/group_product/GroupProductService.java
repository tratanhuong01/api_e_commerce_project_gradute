package com.api.api_e_commerce_project_gradute.group_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupProductService {

  @Autowired
  GroupProductRepository groupProductRepository;

  public List<GroupProduct> getAllGroupProducts() {
    return groupProductRepository.findAll();
  }

  public GroupProduct getGroupProductById(String idGroupProduct) {
    return groupProductRepository.getById(idGroupProduct);
  }

  public GroupProduct addGroupProduct(GroupProduct groupProduct) {
    return groupProductRepository.save(groupProduct);
  }

}
